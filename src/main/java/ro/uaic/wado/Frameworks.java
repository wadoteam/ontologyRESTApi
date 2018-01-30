package ro.uaic.wado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Frameworks {
    @GET
    public String getList() {
        return "Hello";
    }
}
