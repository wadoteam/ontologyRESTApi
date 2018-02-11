package wado.rs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import wado.model.Project;
import wado.model.User;

@Path("/users")
@Transactional
public class UsersRS {
    private EntityManager em;

    @PostConstruct
    public void init() {
        this.em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<User> getUsers() {
        return this.em.createQuery("select u from User u").getResultList();
    }

    @GET
    @Path("/{email}")
    @Produces("application/json")
    public User getUserByEmail(@PathParam("email") String email) {
        return this.em.find(User.class, email);
    }

    @SuppressWarnings("unchecked")
    @GET
    @Path("/{user}/projects")
    @Produces("application/json")
    public List<Project> getProjectsByUser(@PathParam("user") String user) {
        return this.em.createQuery("select p from Project p where p.user.email=?").setParameter(1, user).getResultList();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public User addUser(User user) {
        this.em.persist(user);
        return user;
    }


}