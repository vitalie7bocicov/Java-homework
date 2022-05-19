package uaic.jdbc;

import DAO.ContinentDAO;
import DAO.CountryDAO;
import java.sql.SQLException;

/**
 *
 * @author vital
 */
public class Main {

    public static void main(String args[]) {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
//TODO: print all the countries in Europe

            System.out.println("Countries in Europe:");
            String countryName;
            while ((countryName = countries.findByContinent(europeId)) != null) {
                System.out.println(countryName);
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            // Database.rollback();
        }
    }
}
