package io.swagger.api;

import io.swagger.model.Repository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/repositories")

@Api(description = "the repositories API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class RepositoriesApi  {

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get repositories", notes = "Get repositories", response = Repository.class, responseContainer = "List", tags={ "repository" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List") })
    public Response getRepositories(@QueryParam("paradigms")  List<String> paradigms,@QueryParam("framework")  String framework,@QueryParam("programming_language")  String programmingLanguage,@QueryParam("page")  @DefaultValue("1") Integer page) {
        return Response.ok().entity("magic!").build();
    }
}

