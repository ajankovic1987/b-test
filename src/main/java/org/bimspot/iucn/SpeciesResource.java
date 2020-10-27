package org.bimspot.iucn;

import org.bimspot.iucn.model.ConservationMeasure;
import org.bimspot.iucn.model.Region;
import org.bimspot.iucn.model.Species;
import org.bimspot.iucn.model.SpeciesCategory;
import org.bimspot.iucn.service.ConservationMeasuresService;
import org.bimspot.iucn.service.RegionsService;
import org.bimspot.iucn.service.SpeciesService;
import org.bimspot.iucn.service.result.ConservationMeasureResult;
import org.bimspot.iucn.service.result.RegionsResult;
import org.bimspot.iucn.service.result.SpeciesResult;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Exposes endpoint /species which returns a list of critically endangered species for a randomly
 * chosen region with conservation measures, and a list of species that belong to the mammal class,
 * also for the chosen region.
 */
@Path("/species")
public class SpeciesResource {

    private static final Logger LOG = Logger.getLogger(SpeciesResource.class);

    private static final String mammalClassName = "MAMMALIA";

    @ConfigProperty(name = "iucn.api.token")
    String token;

    @Inject
    @RestClient
    SpeciesService speciesService;

    @Inject
    @RestClient
    RegionsService regionsService;

    @Inject
    @RestClient
    ConservationMeasuresService conservationMeasuresService;

    @GET
    @Produces("application/json")
    public Result getSpecies() {
        Result result = new Result();
        RegionsResult regionsResult = regionsService.getRegions(token);
        if (regionsResult != null && regionsResult.count > 0) {
            List<Region> regions = regionsResult.results;
            int randomIndex = new Random().nextInt(regions.size());
            Region chosenRegion = regions.get(randomIndex);
            if (chosenRegion != null) {
                LOG.info("Randomly chosen region: " + chosenRegion);
                SpeciesResult speciesResult = speciesService.getByRegion(chosenRegion.identifier,
                        token);
                if (speciesResult != null && speciesResult.count > 0) {
                    List<Species> regionSpecies = speciesResult.result;
                    LOG.info("Species in chosen region: " + regionSpecies);
                    result.criticallyEndangeredSpecies = getCriticallyEndangeredSpecies(speciesResult);
                    LOG.info("Critically endangered species with conservation measures: " + result.criticallyEndangeredSpecies);
                    result.mammalSpecies =
                            regionSpecies.stream()
                                    .filter(species -> species.className.equals(mammalClassName))
                                    .collect(Collectors.toList());
                    LOG.info("Species belonging to class MAMMALIA: " + result.mammalSpecies);
                }
            }
        }
        return result;
    }

    private List<Species> getCriticallyEndangeredSpecies(SpeciesResult speciesResult) {
        return speciesResult.result.subList(0, 100).stream()
                .filter(species -> species.category == SpeciesCategory.CRITICALLY_ENDANGERED)
                .map(species -> {
                    ConservationMeasureResult conservationMeasureResult =
                            conservationMeasuresService.getConservationMeasures(species.scientificName, speciesResult.regionIdentifier, token);
                    if (conservationMeasureResult != null) {
                        updateSpeciesConservationMeasures(species,
                                conservationMeasureResult.result);
                    }
                    return species;
                }).collect(Collectors.toList());
    }

    private Species updateSpeciesConservationMeasures(Species species,
                                                      List<ConservationMeasure> conservationMeasures) {
        if (conservationMeasures != null && conservationMeasures.size() > 0) {
            species.conservationMeasures =
                    conservationMeasures.stream()
                            .map(conservationMeasure -> conservationMeasure.title)
                            .collect(Collectors.joining(", "));
        }
        return species;
    }
}
