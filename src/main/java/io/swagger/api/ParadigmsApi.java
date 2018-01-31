package io.swagger.api;

import io.swagger.model.Paradigm;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/paradigms")

@Api(description = "the paradigms API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class ParadigmsApi  {

    @GET
    @Path("/{name}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a paradigm by name", notes = "Get a paradigm by name", response = Paradigm.class, tags={ "concepts",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Paradigm.class) })
    public Response getParadigmByName(@PathParam("name") @ApiParam("The name of the paradigm") String name) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get paradigms", notes = "Get a list of available paradigms", response = Paradigm.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Paradigm.class, responseContainer = "List") })
    public Response getParadigms() {
        return Response.ok().entity("magic!").build();
    }
}

