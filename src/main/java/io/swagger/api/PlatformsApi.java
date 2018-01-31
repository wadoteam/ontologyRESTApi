package io.swagger.api;

import io.swagger.model.Platform;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/platforms")

@Api(description = "the platforms API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class PlatformsApi  {

    @GET
    @Path("/{key}")
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a platform by name", notes = "Get a platforms by name", response = Platform.class, tags={ "concepts",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Platform.class) })
    public Response getPlatformByName(@PathParam("key") @ApiParam("The key of the platform") String key) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get platforms", notes = "Get a list of available platforms", response = Platform.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Platform.class, responseContainer = "List") })
    public Response getPlatforms() {
        return Response.ok().entity("magic!").build();
    }
}

