package io.swagger.sparql;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import java.util.Map;

public class RecomandationRequests extends SparqlRequest {

    private String classToBeRecomadate;

    public RecomandationRequests(String c) {
        this.classToBeRecomadate = c;
    }

    public ResultSet get() {
        Map<String, String> classes = Utils.getFeatureMap();

        SelectBuilder sb = new SelectBuilder()
                .addVar( "?recomandation" )
                .addVar( "?repo" )
                .addVar( "?issue" )
                .addWhere( "?recomandation", RDF.type, classes.get(classToBeRecomadate) )
                .addWhere( "?recomandation", "base:hasRepository", "?repo" )
                .addWhere( "?repo", "base:hasIssue", "?issue" )
                .addOptional("?knownFeature", RDFS.subClassOf,"?parrentClass")
                .addOptional("?recomandation", RDFS.subClassOf,"?parrentClass");

        return runQuery(sb);
    }
}
