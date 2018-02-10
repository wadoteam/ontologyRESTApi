package io.swagger.api;

import io.swagger.model.Repository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

import java.util.List;

@Path("/repositories")
@Api(description = "the repositories API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")
public class RepositoriesApi {
    @GET
    @Produces({"application/json"})
    @ApiOperation(value = "Get repositories", notes = "Get repositories", response = Repository.class, responseContainer = "List", tags = {"repository"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List")})
    public Response getRepositories(@QueryParam("paradigms") List<String> paradigms, @QueryParam("framework") String framework, @QueryParam("programming_language") String programmingLanguage, @QueryParam("page") @DefaultValue("1") Integer page) {
        String s = execSelectAndPrint("SELECT ?subject ?predicate ?object" +
                "WHERE {" +
                "  ?subject ?predicate ?object" +
                "}" +
                "LIMIT 25");

        return Response.ok().entity(s).build();
    }

    private String execSelectAndPrint(String query) {
        QueryExecution q = QueryExecutionFactory.sparqlService("http://localhost:3030/wado",
                query);
        ResultSet results = q.execSelect();

        String s = "";

        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            s += soln;
        }

        return s;
    }

}

