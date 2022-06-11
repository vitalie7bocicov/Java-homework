package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author vital
 */
public class DatabaseCP {

    private static BasicDataSource ds = new BasicDataSource();

    private static final String url = "jdbc:postgresql://localhost:5432/cities";
    private static final String user = "postgres";
    private static final String password = "admin";

    static {
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setInitialSize(16);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DatabaseCP() {

    }

}
