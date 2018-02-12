package wado.rs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import wado.EMF;
import wado.model.Project;

@Path("/projects")
@Transactional
public class ProjectsRS {
    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<Project> getProjects() {
        return EMF.createEntityManager().createQuery("select p from Project p").getResultList();

    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Project getProjectById(@PathParam("id") Integer projectId) {
        return EMF.createEntityManager().find(Project.class, projectId);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Project saveProject(Project project) {
        EMF.createEntityManager().getTransaction().begin();
        EMF.createEntityManager().persist(project);
        EMF.createEntityManager().flush();
        EMF.createEntityManager().getTransaction().commit();
        EMF.createEntityManager().close();
        return project;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam("id") Integer id) {
        EMF.createEntityManager().remove(this.getProjectById(id));

    }
}
