package repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Continent;
import model.Country;
import utils.PersistenceUtil;

/**
 *
 * @author vital
 */
public class CountryRepository extends DataRepository<Country> {

    private EntityManager em = PersistenceUtil.getEntityManager();

    public Country findById(int id) {
        try {
            Country territory = (Country) em.createQuery(
                    "SELECT c FROM Country c WHERE c.id =" + id)
                    .getSingleResult();
            return territory;
        } catch (NoResultException e) {
            return null;
        }

    }

    public List<Country> findByContinent(Continent continent) {
        return em.createNamedQuery("Country.findByContinent")
                .setParameter("continent", continent)
                .getResultList();
    }

    public List<Country> findByName(String name) {
        return em.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public long count() {
        return (long) em.createQuery("SELECT count(c) FROM Country c")
                .getSingleResult();
    }
}
