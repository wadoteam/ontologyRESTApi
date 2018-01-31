package io.swagger.api;

import io.swagger.model.Framework;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/frameworks")

@Api(description = "the frameworks API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class FrameworksApi  {

    @GET
    @Path("/{name}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a framework by name", notes = "Get a framework by name", response = Framework.class, tags={ "concepts",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Framework.class) })
    public Response getFrameworkByName(@PathParam("name") @ApiParam("The name of the framework") String name) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get frameworks", notes = "Get a list of available frameworks", response = Framework.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Framework.class, responseContainer = "List") })
    public Response getFrameworks(@QueryParam("has_support_for_programming_language")  String hasSupportForProgrammingLanguage,@QueryParam("has_paradigm")  String hasParadigm) {
        return Response.ok().entity("magic!").build();
    }
}

