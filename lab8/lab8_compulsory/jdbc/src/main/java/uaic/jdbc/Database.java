package uaic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vital
 */
public class Database {

    private static final String url = "jdbc:postgresql://localhost:5432/cities";
    private static final String user = "postgres";
    private static final String password = "admin";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        if (connection != null)
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}
