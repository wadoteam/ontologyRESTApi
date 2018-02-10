package io.swagger.sparql;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;

import java.util.Map;

abstract class SparqlRequest {
    abstract ResultSet get();

    public ResultSet runQuery(SelectBuilder sb) {

        Map<String, String> prefixes = Utils.getPrefixesMap();
        for (Map.Entry<String, String> entry : prefixes.entrySet()) {
            sb.addPrefix(entry.getKey(), entry.getValue());
        }

        Query query = QueryFactory.create(sb.buildString());
        QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoint.endpoint, query);

        ResultSet results = qexec.execSelect();

        qexec.close();
        return results;
    }

}
