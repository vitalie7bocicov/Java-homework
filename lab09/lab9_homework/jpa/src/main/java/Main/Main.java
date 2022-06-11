package Main;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.City;
import repositories.CityRepository;
import utils.ChocoSolver;
import utils.FakeCityUtil;

/**
 *
 * @author vital
 */
public class Main {

    private void insertFakeCities() {
        FakeCityUtil cityGen = new FakeCityUtil();
        try {
            cityGen.create(5000);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllCities() {
        CityRepository cities = new CityRepository();
        List<City> cityList = cities.findAll();

        for (City city : cityList) {
            System.out.println(city.getName());
        }
    }

    private void solve() {
        ChocoSolver solver = new ChocoSolver();
        solver.solve();
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.insertFakeCities();
//        test.getAllCities();
//        test.getAllIds();
//        test.solve();
    }
}
