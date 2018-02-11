package io.swagger.sparql;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.vocabulary.RDF;
import wado.model.Recomandation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchitecturalPatternRequest extends SparqlRequest {
    public ResultSet get() {
        Map<String, String> classes = Utils.getFeatureMap();

        String query = "select distinct ?pattern ?abstract  where {\n" +
                "{SERVICE <http://dbpedia.org/sparql> {\n" +
                "    ?pattern <http://purl.org/dc/terms/subject> <http://dbpedia.org/resource/Category:Architectural_pattern_(computer_science)>.\n" +
                "      ?pattern dbo:abstract ?abstract.\n" +
                "   FILTER(LANGMATCHES(LANG(?abstract), \"en\"))\n" +
                "\n" +
                "    }}\n" +
                "}\n" +
                "limit 30";

        return runQuery(query);
    }

    public List<Map<String, String>>  toList(){
        List<Map<String, String>> results = new ArrayList<>();
        ResultSet result = this.get();
        while (result.hasNext()) {
            QuerySolution row = result.next();
            Map<String, String> entry = new HashMap<>();
            entry.put(row.get("pattern").asResource().getLocalName(), row.get("abstract").asLiteral().toString());
            results.add(entry);
        }
        return results;
    }
}