package wado.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Application {
    @GET
    public String getProjects() {
        return "Traiasca berea";
    }
}
