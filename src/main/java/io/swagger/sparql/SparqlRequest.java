package io.swagger.sparql;

import org.apache.jena.query.ResultSet;

public interface SparqlRequest {
    public ResultSet get();
}
