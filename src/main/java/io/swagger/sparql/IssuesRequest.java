package io.swagger.sparql;

import org.apache.jena.query.*;

public class IssuesRequest extends SparqlRequest {

    private String repo;
    public IssuesRequest(String repo) {
        this.repo = repo;
    }
    public ResultSet get() {
    
        return null;
    }
}
