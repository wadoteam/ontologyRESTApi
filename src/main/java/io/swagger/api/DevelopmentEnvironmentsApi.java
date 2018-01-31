package io.swagger.api;

import io.swagger.model.DevelopmentEnvironment;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

@Path("/development-environments")

@Api(description = "the development-environments API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class DevelopmentEnvironmentsApi  {

    @GET
    @Path("/{name}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a development environment by name", notes = "Get a development environment by name", response = DevelopmentEnvironment.class, tags={ "concepts",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DevelopmentEnvironment.class) })
    public Response getDevelopmentEnvironmentByName(@PathParam("name") @ApiParam("The name of the development environment") String name) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get development environments", notes = "Get a list of available development environments", response = DevelopmentEnvironment.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DevelopmentEnvironment.class, responseContainer = "List") })
    public Response getDevelopmentEnvironments(@QueryParam("has_support_for_programming_language")  String hasSupportForProgrammingLanguage,@QueryParam("has_paradigm")  String hasParadigm) {
        return Response.ok().entity("magic!").build();
    }
}

