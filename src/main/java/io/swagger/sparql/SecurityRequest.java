package io.swagger.sparql;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.*;
import org.apache.jena.vocabulary.RDF;

import java.util.Map;

public class SecurityRequest extends SparqlRequest{
    public ResultSet get() {
        Map<String, String> classes = Utils.getFeatureMap();
        SelectBuilder sb = new SelectBuilder()
                .addVar("?vulnerability")
                .addVar("?attack")
                .addVar("?attackTool")
                .addVar("?attackTarget")
                .addVar("?attackResult")
                .addWhere("?vulnerability", RDF.type, "base2:" + getVulnerabilityForProject("aici e un obiect de fapt"))
                .addWhere("?attack", "base2:exploitsVulnerability", "?vulnerability")
                .addOptional("?attack", "base2:hasTarget", "?atackResult")
                .addOptional("?attack", "base2:hasAttackResult", "?atackResult")
                .addOptional("?attack", "base2:useAttackTool", "?atackTooL");

        return null;

    }

    private String getVulnerabilityForProject(String project) {
        switch (project) {
            case "database": return "Injection";
            case "frontend language": return "CrossSiteScriptinng";
            default:return "CrossSiteScriptinng";
        }
    }
}
