package io.swagger.sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

abstract class SparqlRequest {
	public ResultSet runQuery(String queryRaw) {
		ResultSet results;

		queryRaw = Utils.PREFIXES + queryRaw;

		Query query = QueryFactory.create(queryRaw);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(SparqlEndpoint.endpoint, query);

		results = qexec.execSelect();

		return results;
	}

}
