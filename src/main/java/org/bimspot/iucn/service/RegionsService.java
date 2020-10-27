package org.bimspot.iucn.service;

import org.bimspot.iucn.service.result.RegionsResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Services used to make a call to the IUCN API for fetching the list of regions.
 */
@Path("v3")
@RegisterRestClient
public interface RegionsService {

    @GET
    @Path("/region/list")
    @Produces("application/json")
    RegionsResult getRegions(@QueryParam("token") String token);
}
