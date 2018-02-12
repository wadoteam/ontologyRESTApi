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

import wado.EMF;
import wado.model.Project;
import wado.model.User;

@Path("/users")
@Transactional
public class UsersRS {


    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<User> getUsers() {

        return EMF.createEntityManager().createQuery("select u from User u").getResultList();

    }

    @GET
    @Path("/{email}")
    @Produces("application/json")
    public User getUserByEmail(@PathParam("email") String email) {

        return EMF.createEntityManager().find(User.class, email);

    }

    @GET
    @Path("/{user}/projects")
    @Produces("application/json")
    public List<Project> getProjectsByUser(@PathParam("user") Integer user) {

        return EMF.createEntityManager().createQuery("select p from Project p where p.user.id= :user", Project.class).setParameter("user", user).getResultList();

    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public User addUser(User user) {

        EMF.createEntityManager().persist(user);

        return user;
    }


}