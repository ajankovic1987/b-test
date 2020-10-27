package org.bimspot.iucn.service;

import org.bimspot.iucn.service.result.ConservationMeasureResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

/**
 * Services used to make a call to the IUCN API for fetching the conservation measures for the
 * specified species in the specified region.
 */
@Path("v3")
@RegisterRestClient
public interface ConservationMeasuresService {

    @GET
    @Path("/measures/species/name/{speciesName}/region/{region}")
    @Produces("application/json")
    ConservationMeasureResult getConservationMeasures(@PathParam("speciesName") String speciesName, @PathParam("region") String region, @QueryParam("token") String token);
}
