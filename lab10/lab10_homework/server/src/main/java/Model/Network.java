package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vital
 */
public class Network {

    private Map<String, User> users;

    public Network() {
        users = new HashMap<>();
    }

    public String addUser(User user) {
        if (users.containsKey(user.getName())) {
            return "username already exists! please try another one...";
        }
        users.put(user.getName(), user);
        return "User " + user.getName() + " has been successfully registered! You can login now!";
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public String getUsers() {
        String usernames = "";
        for (String username : users.keySet()) {
            usernames += username + " ";
        }
        return usernames;
    }

}
