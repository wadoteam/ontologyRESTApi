package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Repository;
import io.swagger.sparql.RecomandationRequests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;



public class IssuesApi {
    @GET
    @Produces({"application/json"})
    @ApiOperation(value = "Get issues for a project", notes = "Get issues", response = Repository.class, responseContainer = "List", tags = {"repository"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List")})
    public Response getRepositories(@PathParam("project") String project) {

        IssuesApi response = new IssuesApi();
        System.out.println(response.toString());


        return Response.ok().entity("magic!").build();
    }
}
