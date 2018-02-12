package io.swagger.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Repository;
import io.swagger.sparql.RecomandationRequests;
import wado.model.Characteristic;

@Path("/{project}/recomandation")

@Api(description = "the recomandation API")

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2018-01-31T23:29:20.245Z")

public class RecomandationsApi {

    private EntityManager em;

    @PostConstruct
    public void init() {
        this.em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    }
    
    @GET
    @Produces({"application/json"})
    @ApiOperation(value = "Get recomandation for a project", notes = "Get recomandation", response = Repository.class, responseContainer = "List", tags = {"repository"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Repository.class, responseContainer = "List")})
    public Response getRepositories(@PathParam("project") String project) {
    	List<Characteristic> characteristics = this.em.createQuery("select c from Characteristic c where c.project.id = :id").setParameter("id", project).getResultList();
    	Map<String, String> properties = new HashMap<String, String>();
    	for(Characteristic c : characteristics){
    		properties.put(c.getCharacteristicType(), c.getCharacteristicValue());
    	}

    	String language = "base:" + properties.getOrDefault("language", "");
    	String framework = "base2:" + properties.getOrDefault("framework", "");
    	String database = "base2:" + properties.getOrDefault("database", "");
    	String ide = "base2:" + properties.getOrDefault("ide", "");

        RecomandationRequests response = new RecomandationRequests(project);
        Map<String, List<List<Object>>> allData = new HashMap<>();
        allData.put("Language", response.toList("language", language));
        allData.put("Framework", response.toList("framework", framework));
        allData.put("Database", response.toList("database", database));
        allData.put("IDE", response.toList("IDE", ide));
        return Response.ok().entity(allData).build();
    }
}
