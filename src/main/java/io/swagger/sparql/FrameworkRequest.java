package io.swagger.sparql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

public class FrameworkRequest extends SparqlRequest {

	public List<Map<String, String>> getAllFrameworks() {
		String query = "SELECT ?framework  " + "WHERE { ?framework rdf:type base2:Framework }";
		return toList(runQuery(query));
	}

	public List<Map<String, String>> toList(ResultSet rs) {
		List<Map<String, String>> results = new ArrayList<>();

		while (rs.hasNext()) {
			QuerySolution row = rs.next();
			Map<String, String> rowMap = new HashMap<>();
			rowMap.put("framework", row.get("framework").asResource().getLocalName());
			results.add(rowMap);
		}
		return results;
	}
}
