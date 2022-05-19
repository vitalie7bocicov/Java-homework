package repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Continent;
import utils.PersistenceUtil;

/**
 *
 * @author vital
 */
public class ContinentRepository extends DataRepository<Continent> {

    private EntityManager em = PersistenceUtil.getEntityManager();

    public Continent findById(int id) {
        try {
            Continent territory = (Continent) em.createQuery(
                    "SELECT c FROM Continent c WHERE c.id =" + id)
                    .getSingleResult();
            return territory;
        } catch (NoResultException e) {
            return null;
        }

    }

    public List<Continent> findByName(String name) {
        return em.createNamedQuery("Continent.findByName")
                .setParameter("name", name)
                .getResultList();
    }
}
