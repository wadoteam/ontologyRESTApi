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

import wado.model.Project;

@Path("/projects")
@Transactional
public class ProjectsRS {
    private EntityManager em;

    private EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        this.emf = Persistence.createEntityManagerFactory("my-pu");
        this.em = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<Project> getProjects() {
        try {
            return this.em.createQuery("select p from Project p").getResultList();
        } finally {
            this.em.close();
            emf.close();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Project getProjectById(@PathParam("id") Integer projectId) {
        try {
            return this.em.find(Project.class, projectId);
        } finally {
            this.em.close();
            emf.close();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Project saveProject(Project project) {
        this.em.getTransaction().begin();
        this.em.persist(project);
        this.em.flush();
        this.em.getTransaction().commit();
        this.em.close();
        emf.close();
        return project;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam("id") Integer id) {
        try {
            this.em.remove(this.getProjectById(id));
        } finally {
            this.em.close();
            emf.close();
        }
    }
}
