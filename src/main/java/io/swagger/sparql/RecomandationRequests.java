package io.swagger.sparql;

import com.hp.hpl.jena.graph.Triple;
import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import wado.model.Recomandation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecomandationRequests extends SparqlRequest {

    private Integer classToBeRecomadate;

    public RecomandationRequests(Integer c) {
        this.classToBeRecomadate = c;
    }

    public ResultSet get(String key, String knowProperty) {
        Map<String, String> classes = Utils.getFeatureMap();
        String queryRaw = "select distinct ?repo ?link ?license ?description\n"+
                "where {\n"+
                classes.get(key)+" base:hasRepository ?repo .\n"+
  				"?repo base:hasLink ?link .\n"+
                "?repo base:hasLicense ?license\n"+
                "optional { \n"+
                "?recomandation base:hasDescription ?description .\n"+
                "?recomandation rdfs:subClassOf ?parrentClass\n"+
                "}} limit 10";
        return runQuery(queryRaw);
    }

    public List<List<Object>> toList(String key, String knownProperty) {
        List<Recomandation> results = new ArrayList<>();
        ResultSet result = this.get(key, knownProperty);
        while (result.hasNext()) {
            QuerySolution row = result.next();
            boolean find = false;
            try{
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).recomandationName.equals(row.get("repo").asResource().getLocalName())) {
                    results.get(i).repo.add(row.get("link").asLiteral().toString());
                    find = true;
                    break;
                }
            }
            if (!find) {
                Recomandation rowMap = new Recomandation();
                rowMap.recomandationName = row.get("repo").asResource().getLocalName();
                rowMap.license = row.get("license").asResource().getLocalName();
                rowMap.description = row.get("description") != null ? row.get("description").asResource().getLocalName() : "";
                rowMap.repo.add(row.get("link").asLiteral().toString());
                results.add(rowMap);
            }}catch (Exception e) {
                continue;
            }
        }
        List<List<Object>> r = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            List<Object> a = new ArrayList<>();
            a.add(results.get(i).recomandationName);
            a.add(results.get(i).description);
            a.add(results.get(i).license);
            a.add(results.get(i).repo);
            r.add(a);
        }
        return r;
    }
}
