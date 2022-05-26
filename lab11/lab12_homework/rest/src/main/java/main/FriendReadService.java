package main;

import dao.FriendsDAO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author vital
 */
@Service
public class FriendReadService {

    public Map<String, List<User>> read() throws SQLException {
        FriendsDAO friendUtil = new FriendsDAO();
        Map<String, List<User>> friends = friendUtil.findAll();

        return friends;
    }
}
