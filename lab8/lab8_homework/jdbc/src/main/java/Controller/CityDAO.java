package Controller;

import db.Database;
import db.DatabaseCP;
import Model.City;
import Model.Continent;
import Model.Country;
import Model.Territory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vital
 */
public class CityDAO implements TerritoryDAO {

    public void create(Territory territory) throws SQLException {
        City city = (City) territory;
        try ( Connection con = DatabaseCP.getConnection();  PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (name, country, capital, latitude,longitude  ) values (?,?,?,?,?)")) {
            if (con == null) {
            }
            String name = city.getName();

            int index = name.indexOf('\'');
            if (index >= 0) {
                name = name.substring(0, index) + "'" + name.substring(index);
            }

            pstmt.setString(1, name);
            pstmt.setInt(2, city.getCountry().getId());
            String isCapital = city.isCapital() ? "y" : "n";
            pstmt.setString(3, isCapital);
            pstmt.setDouble(4, city.getLatitude());
            pstmt.setDouble(5, city.getLongitude());
            pstmt.executeUpdate();
        }
    }

    public Territory findByName(String name) throws SQLException {

        int index = name.indexOf('\'');
        if (index >= 0) {
            name = name.substring(0, index) + "\'" + name.substring(index);
        }
        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from cities where name='" + name + "'")) {
            if (rs.next()) {
                var countries = new CountryDAO();
                City city = new City(rs.getString(2));
                city.setId(1);
                city.setCountry((Country) countries.findById(rs.getInt(3)));
                city.setCapital(rs.getString(4).equals("y"));
                city.setLatitude(rs.getDouble(5));
                city.setLongitude(rs.getDouble(6));
                return city;
            }
            return null;
        }
    }

    public Territory findById(int id) throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from cities where id=" + id)) {
            if (rs.next()) {
                var countries = new CountryDAO();
                City city = new City(rs.getString(2));
                city.setId(1);
                city.setCountry((Country) countries.findById(rs.getInt(3)));
                city.setCapital(rs.getString(4).equals("y"));
                city.setLatitude(rs.getDouble(5));
                city.setLongitude(rs.getDouble(6));
                return city;
            }
            return null;
        }
    }

    public int count() throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select count(*) from cities")) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

}
