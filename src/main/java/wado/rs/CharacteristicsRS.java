package wado.rs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import wado.model.Characteristic;

@Path("/characteristics")
@Transactional
public class CharacteristicsRS {

    private EntityManager em;

    @PostConstruct
    public void init() {
        this.em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<Characteristic> getCharacteristics() {
        try {
            return this.em.createQuery("select c from Characteristic c").getResultList();
        } finally {
            this.em.close();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Characteristic getCharacteristicById(@PathParam("id") Integer characteristicId) {
        try {
            return this.em.find(Characteristic.class, characteristicId);
        } finally {
            this.em.close();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Characteristic saveCharacteristic(Characteristic characteristic) {
        this.em.getTransaction().begin();
        this.em.persist(characteristic);
        this.em.flush();
        this.em.getTransaction().commit();
        this.em.close();
        return characteristic;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCharacteristic(@PathParam("id") Integer id) {
        try {
            this.em.remove(this.getCharacteristicById(id));
        } finally {
            this.em.close();
        }
    }
}
