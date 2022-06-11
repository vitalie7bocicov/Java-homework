package Controller;

import Model.Territory;
import java.sql.SQLException;

/**
 *
 * @author vital
 */
public interface TerritoryDAO {

    public void create(Territory territory) throws SQLException;

    public Territory findByName(String name) throws SQLException;

    public Territory findById(int id) throws SQLException;
}
