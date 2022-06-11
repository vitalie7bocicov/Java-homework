package Tools;

import Controller.*;
import Model.City;
import Model.Territory;
import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vital
 */
public class CityGenerator {

    private double generateLat() {
        double minLat = -90.00;
        double maxLat = 90.00;
        double latitude = minLat + (double) (Math.random() * ((maxLat - minLat) + 1));
        return latitude;

    }

    private double generateLon() {
        double minLon = 0.00;
        double maxLon = 180.00;
        double longitude = minLon + (double) (Math.random() * ((maxLon - minLon) + 1));
        return longitude;
    }

    private int getRandId(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }

    private Territory randCountry() throws SQLException {
        CountryDAO countries = new CountryDAO();
        Territory country;
        int nrCountries = countries.count();
        int randomId = getRandId(nrCountries);
        while ((country = countries.findById(randomId)) == null) {
            randomId = getRandId(nrCountries);
            System.out.println("random id: " + randomId);
        }
        return country;
    }

    public void createCity() throws SQLException {
        CityDAO cities = new CityDAO();
        Faker faker = new Faker();
        String cityName = faker.address().city();

        while (cities.findByName(cityName) != null) {
            cityName = faker.address().city();
        }

        double latitude = generateLat();
        double longitude = generateLon();
        Territory country = randCountry();
        Territory city = new City(cityName, country, false, latitude, longitude);

        cities.create(city);

    }

    public void create(int nr) throws SQLException, InterruptedException {
        CityDAO cities = new CityDAO();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
        for (int i = 0; i < nr; i++) {
            Runnable task = new Runnable() {
                public void run() {
                    try {
                        createCity();
                    } catch (SQLException ex) {
                        Logger.getLogger(CityGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            executor.execute(task);
        }

        int time = 0;
        int citiesCreated = 0;
        while (true) {
            citiesCreated = cities.count();
            System.out.println("cities count: " + cities.count());
            Thread.sleep(1000);
            System.out.println("time: " + time++);
            if (citiesCreated == cities.count())//no inserted cities in 1 second
            {
                break;
            }
        }
        executor.shutdown();
        System.out.println("finished!");
    }
}
