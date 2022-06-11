package Tools;

import Controller.CityDAO;
import Controller.ContinentDAO;
import Controller.CountryDAO;
import Controller.TerritoryDAO;
import Model.City;
import Model.Continent;
import Model.Country;
import Model.Territory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author vital
 */
public class ImportTool {

    private void insertContinents(String continentName) throws SQLException {
        Territory continent = new Continent(continentName);
        TerritoryDAO continentDAO = new ContinentDAO();
        if (continentDAO.findByName(continentName) == null) {
            continentDAO.create(continent);
        }
    }

    private void insertCountries(String countryName, String countryCode, String continentName) throws SQLException {
        TerritoryDAO continentDAO = new ContinentDAO();
        TerritoryDAO countryDAO = new CountryDAO();
        Territory country = new Country(countryName, countryCode, continentDAO.findByName(continentName));

        if (countryDAO.findByName(countryName) == null) {
            countryDAO.create(country);
        }
    }

    private void insertCities(String capitalName, double capitalLatitude, double capitalLongitude, String countryName) throws SQLException {
        TerritoryDAO countryDAO = new CountryDAO();
        TerritoryDAO cityDAO = new CityDAO();
        Territory city = new City(capitalName, countryDAO.findByName(countryName), true, capitalLatitude, capitalLongitude);

        if (cityDAO.findByName(capitalName) == null) {
            cityDAO.create(city);
        }
    }

    public void execute() throws SQLException, FileNotFoundException, IOException {

        BufferedReader lineReader = new BufferedReader(new FileReader("concap.csv"));

        String lineText = null;

        lineReader.readLine(); // skip header line

        while ((lineText = lineReader.readLine()) != null) {
            //CountryName,CapitalName,CapitalLatitude,CapitalLongitude,CountryCode,ContinentName

            String[] data = lineText.split(",");
            String countryName = data[0];
            String capitalName = data[1];
            double capitalLatitude = Double.parseDouble(data[2]);
            double capitalLongitude = Double.parseDouble(data[3]);
            String countryCode = data[4];
            String continentName = data[5];

            insertContinents(continentName);

            insertCountries(countryName, countryCode, continentName);

            insertCities(capitalName, capitalLatitude, capitalLongitude, countryName);
        }
        lineReader.close();
    }
}
