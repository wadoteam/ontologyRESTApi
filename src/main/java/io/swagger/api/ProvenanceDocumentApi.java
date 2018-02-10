package io.swagger.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Repository;
import provenance.Git2ProvFetcher;
import provenance.ProvOVizFetcher;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/repositories/provenance")
public class ProvenanceDocumentApi {

    @GET
    @Produces({ "application/json" })
    public Response getRepositoriesProvenanceVizualization(@QueryParam("repo") String repo) throws Exception {
        String provDoc = Git2ProvFetcher.getProvDoc(repo);
        String htmlVizualization = ProvOVizFetcher.getProvDoc(provDoc);
        return Response.ok( htmlVizualization, MediaType.TEXT_PLAIN).build();
    }
}
