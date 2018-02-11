package io.swagger.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Language;
import io.swagger.sparql.LanguageRequest;

@Path("/languages")

@Api(description = "languages API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")


public class LanguagesApi  {

	private LanguageRequest request = new LanguageRequest();
	
    @GET
    @Produces("application/json")
    @ApiOperation(value = "Get languages", notes = "Get a list of available languages", response = Language.class, responseContainer = "List", tags={ "concepts" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Language.class, responseContainer = "List") })
    public Response getLanguages() {
    	
    	return Response.ok().entity(request.getAllLanguages()).build();
    }
}

