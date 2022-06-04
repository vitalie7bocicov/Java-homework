package com.dao;

import com.model.User;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vital
 */
public class FriendsDAO {

    public void create(int user, int friend) throws SQLException {
        try ( Connection con = Database.getConnection();  PreparedStatement pstmt = con.prepareStatement(
                "insert into friends values (?,?)")) {
            pstmt.setInt(1, user);
            pstmt.setInt(2, friend);
            pstmt.executeUpdate();
        }
    }

    public Map<String, List<User>> findAll() throws SQLException {

        try ( Connection con = Database.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from friends ")) {
            Map<String, List<User>> friends = new HashMap<>();
            UserDAO userUtil = new UserDAO();
            while (rs.next()) {
                User user = userUtil.findById(rs.getInt(1));
                User friend = userUtil.findById(rs.getInt(2));
                if (!friends.containsKey(user.getName())) {
                    friends.put(user.getName(), new ArrayList<User>());
                }
                friends.get(user.getName()).add(friend);

                if (!friends.containsKey(friend.getName())) {
                    friends.put(friend.getName(), new ArrayList<User>());
                }
                friends.get(friend.getName()).add(user);

            }
            return friends;
        }
    }

    public Map<Integer, Integer> countFriends() throws SQLException {

        try ( Connection con = Database.getConnection();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(
                "select * from friends ")) {
            Map<Integer, Integer> friends = new HashMap<>();
            while (rs.next()) {
                int user = rs.getInt(1);
                int friend = rs.getInt(2);
                if (!friends.containsKey(user)) {
                    friends.put(user, 0);
                }
                int var = friends.get(user);
                friends.put(user, var + 1);

                if (!friends.containsKey(friend)) {
                    friends.put(friend, 0);
                }
                var = friends.get(friend);
                friends.put(friend, var + 1);

            }
            return friends;
        }
    }
}
