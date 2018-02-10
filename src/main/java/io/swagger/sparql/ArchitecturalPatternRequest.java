package io.swagger.sparql;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import java.util.Map;

public class ArchitecturalPatternRequest extends SparqlRequest {
    public ResultSet get() {
        Map<String, String> classes = Utils.getFeatureMap();

        SelectBuilder sb = new SelectBuilder()
                .addVar("?pattern")
                .addVar("?description")
                .addVar("?framework")
                .addWhere("?pattern", RDF.type, "base2:ArchitecturalPattern")
                .addWhere("?framework", "base:isFrameworkFor", "base:Java")
                .addWhere("?pattern", "base2:isImplementedBy", "?framework")
                .addWhere("?pattern", "dc:description", "?description");

        return runQuery(sb);
    }
}