package repositories;

import java.util.List;
import javax.persistence.EntityManager;
import utils.PersistenceUtil;

/**
 *
 * @author vital
 * @param <T>
 */
public abstract class DataRepository<T> {

    private EntityManager em = PersistenceUtil.getEntityManager();

//    public List<T> findAll() {
//        return em.createNamedQuery("T.findAll")
//                .getResultList();
//    }
//    public List<T> findAll() {
//        return em.createQuery("SELECT c FROM T c")
//                .getResultList();
//    }
    public void persist(T entity) {
        try {
            PersistenceUtil.beginTransaction();
            em.persist(entity);
            PersistenceUtil.commit();
        } catch (Exception e) {
            System.out.println("persist exception: " + e.getMessage());
            PersistenceUtil.rollback();
        }
    }
}
