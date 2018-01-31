package io.swagger.api;

import io.swagger.model.ProgrammingLanguage;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/programming-languages")

@Api(description = "the programming-languages API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class ProgrammingLanguagesApi  {

    @GET
    @Path("/{name}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a programming language by name", notes = "Get a programming language by name", response = ProgrammingLanguage.class, tags={ "concepts",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ProgrammingLanguage.class) })
    public Response getProgrammingLanguageByName(@PathParam("name") @ApiParam("The name of the programming language") String name) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get programming languages", notes = "Get a list of available programming languages", response = ProgrammingLanguage.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ProgrammingLanguage.class, responseContainer = "List") })
    public Response getProgrammingLanguages(@QueryParam("runs_on_platform")  String runsOnPlatform) {
        return Response.ok().entity("magic!").build();
    }
}

