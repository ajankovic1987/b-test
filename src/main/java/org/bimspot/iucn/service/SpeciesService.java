package org.bimspot.iucn.service;

import org.bimspot.iucn.service.result.SpeciesResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

/**
 * Services used to make a call to the IUCN API for fetching the species for the
 * specified region.
 */
@Path("/v3")
@RegisterRestClient
public interface SpeciesService {

    @GET
    @Path("/species/region/{region}/page/0")
    @Produces("application/json")
    SpeciesResult getByRegion(@PathParam("region") String region, @QueryParam("token") String token);
}
