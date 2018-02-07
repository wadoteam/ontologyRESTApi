package wado.rs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import wado.model.Project;
import wado.model.User;

@Path("/projects")
public class ProjectsRS {
	@PersistenceContext(unitName = "my-pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<Project> getProjects() {
		return this.em.createQuery("select p from Projects p").getResultList();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<Project> getProjectsByUser(String user) {
		return this.em.createQuery("select p from Projects p where email=?").setParameter(1, user).getResultList();
	}
	
	@GET
	@Produces("application/json")
	public Project getProjectById(Integer projectId) {
		return this.em.find(Project.class, projectId);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Project saveProject(Project project) {
		if(this.getProjectById(project.getProjectId()) != null){
			this.em.merge(project);
		}
		else{
			this.em.persist(project);
		}
		return project;
	}

}
