package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Repository;
import io.swagger.sparql.RecomandationRequests;
import org.apache.jena.query.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/recomandation/{project}")

@Api(description = "the recomandation API")

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")

public class RecomandationsApi {
    @GET
    @Produces({"application/json"})
    @ApiOperation(value = "Get recomandation for a project", notes = "Get recomandation", response = Repository.class, responseContainer = "List", tags = {"repository"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List")})
    public Response getRepositories(@PathParam("project") String project) {

        RecomandationRequests response = new RecomandationRequests();
        System.out.println(response.toString());


        return Response.ok().entity("magic!").build();
    }
}
