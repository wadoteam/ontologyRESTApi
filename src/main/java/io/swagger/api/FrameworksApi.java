package io.swagger.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Framework;
import io.swagger.sparql.FrameworkRequest;

@Path("/frameworks")

@Api(description = "the frameworks API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class FrameworksApi  {

	private FrameworkRequest request = new FrameworkRequest();
	
    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Get frameworks", notes = "Get a list of available frameworks", response = Framework.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Framework.class, responseContainer = "List") })
    public Response getFrameworks() {
        return Response.ok().entity(request.getAllFrameworks()).build();
    }

    @GET()
    @Produces({ "application/json" })
    @ApiOperation(value = "Get frameworks", notes = "Get a list of available frameworks", response = Framework.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Framework.class, responseContainer = "List") })
    public Response getFrameworksByLanguage(@QueryParam("language")String language) {
        return Response.ok().entity(request.getFrameworksByLanguage(language)).build();
    }
}

