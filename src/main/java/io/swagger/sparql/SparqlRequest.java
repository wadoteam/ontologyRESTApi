package io.swagger.sparql;

import org.apache.jena.query.*;

import java.util.List;
import java.util.Map;

abstract class SparqlRequest {
    abstract ResultSet get();

    public ResultSet runQuery(String queryRaw) {

        queryRaw = Utils.PREFIXES +  queryRaw;

        Query query = QueryFactory.create(queryRaw);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoint.endpoint, query);

        ResultSet results = qexec.execSelect();

        return results;
    }

}
