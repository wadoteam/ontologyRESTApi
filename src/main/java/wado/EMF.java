package wado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener {
    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        if (emf != null)
            emf = Persistence.createEntityManagerFactory("my-pu");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (emf != null)
            emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("my-pu");
        }

        return emf.createEntityManager();
    }

}