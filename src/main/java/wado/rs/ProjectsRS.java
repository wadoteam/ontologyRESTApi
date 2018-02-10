package wado.rs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	@PersistenceContext(unitName = "my-pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<Project> getProjects() {
		return this.em.createQuery("select p from Project p").getResultList();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Project getProjectById(@PathParam("id") Integer projectId) {
		return this.em.find(Project.class, projectId);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Project saveProject(Project project) {
		if (this.getProjectById(project.getProjectId()) != null) {
			this.em.merge(project);
		} else {
			this.em.persist(project);
		}
		return project;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProject(@PathParam("id")Integer id){
		this.em.remove(this.getProjectById(id));
	}
}
