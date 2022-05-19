package utils;

import java.util.List;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import repositories.CityRepository;

/**
 *
 * @author vital
 */
public class ChocoSolver {

    List<Integer> cityList;
    List<Integer> countryList;

    private void getAllIds() {
        CityRepository cities = new CityRepository();
        cityList = cities.findAllIds();
    }

    private void getAllCountries() {
        CityRepository cities = new CityRepository();
        countryList = cities.findAllCountries();
    }

    public void solve() {
        getAllCountries();
        getAllIds();
        int[] citiesArr = cityList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int[] countriesArr = countryList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int nCities = citiesArr.length;
        int nCountries = countriesArr.length;

        Model model = new Model("set of cities");
        IntVar[] cities = new IntVar[nCities];
        for (int q = 0; q < nCities; q++) {
            cities[q] = model.intVar("City_", countriesArr);
        }

        for (int i = 0; i < nCities - 1; i++) {
            for (int j = i + 1; j < nCities; j++) {
                model.arithm(cities[i], "!=", cities[j]).post();
            }
        }
        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            System.out.println(solution.toString());
        }
    }
}
