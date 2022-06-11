package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.Database;
import db.DatabaseCP;
import Model.Continent;
import Model.Country;
import Model.Territory;

/**
 *
 * @author vital
 */
public class CountryDAO implements TerritoryDAO {

    public void create(Territory territory) throws SQLException {
        Country country = (Country) territory;

        try (
                 Connection con = DatabaseCP.getConnection();  PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, code, continent) values (?,?,?)")) {
            pstmt.setString(1, country.getName());
            pstmt.setString(2, country.getCode());
            var continents = new ContinentDAO();
            Territory continent = continents.findByName(country.getContinent().getName());
            pstmt.setInt(3, continent.getId());
            pstmt.executeUpdate();
        }
    }

    public Territory findByName(String name) throws SQLException {
        int index = name.indexOf('\'');
        if (index >= 0) {
            name = name.substring(0, index) + "\'" + name.substring(index);
        }

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from countries where name='" + name + "'")) {
            if (rs.next()) {
                var continents = new ContinentDAO();
                Territory country = new Country(rs.getString(2), rs.getString(3), continents.findById(rs.getInt(4)));
                country.setId(rs.getInt(1));
                return country;
            }
            return null;
        }
    }

    @Override
    public Territory findById(int id) throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from countries where id=" + id)) {
            if (rs.next()) {
                var continents = new ContinentDAO();
                Territory country = new Country(rs.getString(2), rs.getString(3), continents.findById(rs.getInt(4)));
                country.setId(rs.getInt(1));
                return country;
            }
            return null;
        }
    }

    public void findByContinent(int continent) throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select name from countries where continent='" + continent + "'")) {
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        }

    }

    public int count() throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select count(*) from countries")) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

}
