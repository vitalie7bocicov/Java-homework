package com.dao;

import com.model.User;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vital
 */
public class UserDAO {

    public void create(User user) throws SQLException {
        try ( Connection con = Database.getConnection();  PreparedStatement pstmt = con.prepareStatement(
                "insert into users (name) values (?)")) {
            pstmt.setString(1, user.getName());
            pstmt.executeUpdate();
        }
    }

    public User findByName(String name) throws SQLException {
        try (
                 Connection con = Database.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from users where name='" + name + "'")) {
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2));
            }
            return null;

        }
    }

    public User findById(int id) throws SQLException {

        try ( Connection con = Database.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from users where id=" + id)) {
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2));
            }
            return null;
        }
    }

    public List<User> findAll() throws SQLException {

        try ( Connection con = Database.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from users ")) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2)));
            }
            return users;
        }
    }

    public void updateName(int id, String name) throws SQLException {
        try (
                 Connection con = Database.getConnection();  PreparedStatement pstmt = con.prepareStatement("UPDATE users SET name = ? " + "WHERE id = ?");) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (
                 Connection con = Database.getConnection();  PreparedStatement pstmt = con.prepareStatement("delete from users where id=?");) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

}
