package io.swagger.sparql;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, String> getPrefixesMap() {
        Map<String, String> prefixes = new HashMap<>();
        prefixes.put("dbo", "http://dbpedia.org/ontology/");
        prefixes.put("dc", "http://purl.org/dc/elements/1.1/");
        prefixes.put("foaf", "http://xmlns.com/foaf/0.1/");
        prefixes.put("prov", "http://www.w3.org/ns/prov#");
        prefixes.put("obo", "http://purl.obolibrary.org/obo/");
        prefixes.put("dbr", "http://dbpedia.org/resource/");
        prefixes.put("doap", "http://usefulinc.com/ns/doap#");
        prefixes.put("efo", "http://www.ebi.ac.uk/efo/");
        prefixes.put("edamontology", "http://edamontology.org#");
        prefixes.put("swo", "http://www.ebi.ac.uk/swo/");
        prefixes.put("skos", "http://www.w3.org/2004/02/skos/core#");
        prefixes.put("oboInOwl", "http://www.geneontology.org/formats/oboInOwl#");
        prefixes.put("edamontology1", "http://edamontology.org/");
        prefixes.put("dbc", "http://dbpedia.org/resource/Category:");
        prefixes.put("base", "http://webprotege.stanford.edu/project/BNheXqpQbFxGhfZ0oWHJp1");
        prefixes.put("xsd", "http://www.w3.org/2001/XMLSchema#");
        prefixes.put("owl", "http://www.w3.org/2002/07/owl#");
        prefixes.put("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        prefixes.put("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        prefixes.put("base2", "http://webprotege.stanford.edu/");
        return prefixes;
    }

    public static Map<String, String> getFeatureMap() {
        Map<String, String> feature = new HashMap<>();
        feature.put("language", "base:Language");
        feature.put("database", "base:Database");
        feature.put("ide", "base:IntegratedDevelopmentEnvironment");
        return feature;
    }
}
