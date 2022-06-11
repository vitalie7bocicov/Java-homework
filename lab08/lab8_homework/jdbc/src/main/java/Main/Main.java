package Main;

import db.DatabaseCP;
import Controller.CityDAO;
import Controller.ContinentDAO;
import Controller.CountryDAO;
import Controller.TerritoryDAO;
import Tools.ImportTool;
import Model.City;
import Model.Continent;
import Model.Country;
import Model.Territory;
import Tools.CityGenerator;
import Tools.DistanceTool;
import View.MapFrame;
import db.Database;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vital
 */
public class Main {
    
    Territory europe;
    Territory asia;
    Territory romania;
    Territory ukraine;
    
    private void createContinents() throws SQLException {
        europe = new Continent("Europe");
        asia = new Continent("Asia");
        
        var continents = new ContinentDAO();
        continents.create(europe);
        continents.create(asia);
    }
    
    private void createCountries() throws SQLException {
        var countries = new CountryDAO();
        
        romania = new Country("Romania", "RO", europe);
        ukraine = new Country("Ukraine", "UA", europe);
        countries.create(romania);
        countries.create(ukraine);
    }
    
    private void createCities() throws SQLException {
        var cities = new CityDAO();
        
        City iasi = new City("Iasi", romania, false, 47.17, 27.57);
        City bacau = new City("Bacau", romania, false, 46.568, 26.916);
        cities.create(iasi);
        cities.create(bacau);
    }
    
    private void insertData() throws SQLException, IOException {

//            createContinents();
//            createCountries();
//            createCities();
        ImportTool tool = new ImportTool();
        tool.execute();
    }
    
    private void calcDistance(Territory t1, Territory t2) throws SQLException {
        DistanceTool distance = new DistanceTool();
        distance.calculte(t1, t2);
    }
    
    private void fakeCities(int nr) throws SQLException, InterruptedException {
        CityGenerator gen = new CityGenerator();
        gen.create(nr);
    }
    
    public static void main(String args[]) {
        Main test = new Main();
        CityDAO cities = new CityDAO();
        try {
//            test.insertData();
//            test.calcDistance(cities.findByName("Bucharest"), cities.findByName("Luanda"));
//            test.fakeCities(5000);
            MapFrame map = new MapFrame();
            map.draw(
                    cities.findByName("Bucharest"),
                    cities.findByName("Chisinau"),
                    cities.findByName("New York"),
                    cities.findByName("London"),
                    cities.findByName("Moscow"),
                    cities.findByName("Canberra"),
                    cities.findByName("Gaborone"),
                    cities.findByName("Buenos Aires"));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
    }
}
