package io.swagger.sparql;

import com.hp.hpl.jena.graph.Triple;
import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecomandationRequests extends SparqlRequest {

    private String classToBeRecomadate;

    public RecomandationRequests(String c) {
        this.classToBeRecomadate = c;
    }

    public ResultSet get() {
        Map<String, String> classes = Utils.getFeatureMap();
        String queryRaw = "select ?recomandation ?repo ?license " +
                "where {\n" +
                "?recomandation rdf:type base:Language . \n" +
                "?recomandation base:hasRepository ?repo . \n" +
                "?recomandation base:hasLicense ?license\n" +
                "optional { \n" +
                "?knownFeature rdfs:subClassOf ?parrentClass . \n"+
                "?recomandation rdfs:subClassOf ?parrentClass\n"+
                "}}";
        return runQuery(queryRaw);
    }

    public List<Map<String, String>> toList() {
        List<Map<String, String>> results = new ArrayList<>();
        ResultSet result = this.get();
        while (result.hasNext()) {
            QuerySolution row = result.next();
            Map<String, String> rowMap = new HashMap<>();
            rowMap.put("recomandation", row.get("recomandation").asResource().getLocalName());
            rowMap.put("repo", row.get("repo").asResource().getLocalName());
            rowMap.put("license", row.get("license").asResource().getLocalName());
            results.add(rowMap);
        }
        return results;
    }
}
