package io.swagger.sparql;

import org.apache.jena.query.*;

public class IssuesRequest implements SparqlRequest {

    private String repo;
    public IssuesRequest(String repo) {
        this.repo = repo;
    }
    public ResultSet get() {
        String sparqlQuery = "select distinct ?language ?a where {\n" +
                "  ?language rdf:type base:Language.\n" +
                "}";

        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoint.endpoint, query);

        ResultSet results = qexec.execSelect();

        qexec.close();
        return results;
    }
}
