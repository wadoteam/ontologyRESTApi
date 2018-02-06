package wado.rs;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import wado.model.User;

@Path("/users")
public class UsersRS {
	
	@PersistenceContext(unitName = "my-pu")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<User> getDocuments(){
		return this.em.createQuery("select s from Student s").getResultList();
	}
}