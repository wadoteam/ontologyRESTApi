package wado.model;

import java.util.ArrayList;
import java.util.List;

public class Recomandation {
    public String recomandationName;
    public String license;
    public String description;
    public List<String> repo;

    public Recomandation() {
        repo = new ArrayList<>();
    }
}
