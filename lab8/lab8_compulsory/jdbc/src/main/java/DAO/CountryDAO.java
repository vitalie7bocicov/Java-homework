package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uaic.jdbc.Database;

/**
 *
 * @author vital
 */
public class CountryDAO {

    public void create(String name, int continent) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, continent) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, continent);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findByContinent(int continent) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select name from countries where continent='" + continent + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        //TODO
        return "";
    }
}
