package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.Database;
import db.DatabaseCP;
import Model.Continent;
import Model.Territory;

/**
 *
 * @author vital
 */
public class ContinentDAO implements TerritoryDAO {

    public void create(Territory territory) throws SQLException {
        Continent continent = (Continent) territory;

        try ( Connection con = DatabaseCP.getConnection();  PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name) values (?)")) {
            pstmt.setString(1, continent.getName());
            pstmt.executeUpdate();
        }
    }

    public Territory findByName(String name) throws SQLException {
        try (
                 Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from continents where name='" + name + "'")) {
            if (rs.next()) {
                Territory continent = new Continent(rs.getString(2));
                continent.setId(rs.getInt(1));
                return continent;
            }
            return null;

        }
    }

    public Territory findById(int id) throws SQLException {

        try ( Connection con = DatabaseCP.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from continents where id=" + id)) {
            if (rs.next()) {
                Territory continent = new Continent(rs.getString(2));
                continent.setId(rs.getInt(1));
                return continent;
            }
            return null;
        }
    }

}
