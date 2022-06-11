package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.City;
import model.Country;
import utils.PersistenceUtil;

/**
 *
 * @author vital
 */
public class CityRepository extends DataRepository<City> {

    private EntityManager em = PersistenceUtil.getEntityManager();

    public City findById(int id) {
        try {
            City territory = (City) em.createQuery(
                    "SELECT c FROM City c WHERE c.id =" + id)
                    .getSingleResult();
            return territory;

        } catch (NoResultException e) {
            return null;
        }

    }

    public List<City> findByCountry(Country country) {
        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public List<City> findByName(String name) {
        return em.createNamedQuery("City.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public long count() {
        return (long) em.createQuery("SELECT count(c) FROM City c")
                .getSingleResult();
    }

    public List<City> findAll() {
        return em.createNamedQuery("City.findAll")
                .getResultList();
    }

    public List<Integer> findAllIds() {
        return em.createQuery(
                "SELECT c.id FROM City c WHERE c.name LIKE 'A%' and c.population between 30000 AND 50000")
                .getResultList();
    }

    public List<Integer> findAllCountries() {
        List<Country> countries = em.createQuery(
                "SELECT c.country FROM City c WHERE c.name LIKE 'A%' and c.population between 30000 AND 50000")
                .getResultList();
        List<Integer> ids = new ArrayList<>();
        for (Country country : countries) {
            ids.add(country.getId());
        }
        return ids;

    }
}
