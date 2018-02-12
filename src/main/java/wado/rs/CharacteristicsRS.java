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

import wado.EMF;
import wado.model.Characteristic;

@Path("/characteristics")
@Transactional
public class CharacteristicsRS {
    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<Characteristic> getCharacteristics() {

        return EMF.createEntityManager().createQuery("select c from Characteristic c").getResultList();

    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Characteristic getCharacteristicById(@PathParam("id") Integer characteristicId) {

        return EMF.createEntityManager().find(Characteristic.class, characteristicId);

    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Characteristic saveCharacteristic(Characteristic characteristic) {
        EMF.createEntityManager().getTransaction().begin();
        EMF.createEntityManager().persist(characteristic);
        EMF.createEntityManager().flush();
        EMF.createEntityManager().getTransaction().commit();
        EMF.createEntityManager().close();
        return characteristic;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCharacteristic(@PathParam("id") Integer id) {

        EMF.createEntityManager().remove(this.getCharacteristicById(id));

    }
}
