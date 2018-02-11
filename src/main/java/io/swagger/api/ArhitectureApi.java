package io.swagger.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Repository;
import io.swagger.sparql.ArchitecturalPatternRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/{project}/arhitecture_informations")

@Api(description = "information about arhitecture")

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")

public class ArhitectureApi {
    @GET
    @Produces({"application/json"})
    @ApiOperation(value = "Get arhitecture informations", notes = "Get arhitecture informataion", response = Repository.class, responseContainer = "List", tags = {"repository"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List")})
    public Response getRepositories(@PathParam("project") String project) {

        ArchitecturalPatternRequest response = new ArchitecturalPatternRequest();

        return Response.ok().entity(response.toList()).build();
    }
}
