package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vital
 */
public class PersistenceUtil {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    private static String persitenceUnit = "CitiesPU";

    private PersistenceUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(persitenceUnit);
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            getEntityManagerFactory();
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void beginTransaction() {
        em.getTransaction().begin();
    }

    public static void commit() {
        em.getTransaction().commit();
    }

    public static void close() {
        em.close();
        emf.close();
        emf = null;
        em = null;
    }

    public static void rollback() {
        em.getTransaction().rollback();
    }
}
