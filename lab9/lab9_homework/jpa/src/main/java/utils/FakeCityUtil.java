package utils;

import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.City;
import model.Country;
import repositories.CityRepository;
import repositories.CountryRepository;

/**
 *
 * @author vital
 */
public class FakeCityUtil {

    CountryRepository countries;
    CityRepository cities;
    Faker faker;

    public FakeCityUtil() {
        countries = new CountryRepository();
        cities = new CityRepository();
        faker = new Faker();
    }

    private int generatePopulation() {
        return (int) Math.floor(Math.random() * (100_000 - 10_000 + 1) + 10_000);
    }

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

    private long getRandId(long max) {
        return (long) Math.floor(Math.random() * (max + 1));
    }

    private Country randCountry() throws SQLException {

        long nrCountries = countries.count();
        long randomId = getRandId(nrCountries);
        Country country;
        while ((country = countries.findById((int) randomId)) == null) {
            randomId = getRandId(nrCountries);
        }
        return country;
    }

    public void createCity() throws SQLException {

        String cityName = faker.address().city();

        while (!cities.findByName(cityName).isEmpty()) {
            cityName = faker.address().city();
        }

        double latitude = generateLat();
        double longitude = generateLon();
        Country country = randCountry();
        int population = generatePopulation();
        City city = new City(cityName, 'n', latitude, longitude, population, country);
        cities.persist(city);
    }

    public void create(int nr) throws SQLException, InterruptedException {
        Timer timer = new Timer();
        timer.start();
        for (int i = 0; i < nr; i++) {
            createCity();
        }
        timer.kill();
    }

}
