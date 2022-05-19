package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vital
 */
public class User {

    private String name;
    private List<User> friends;
    private Queue<String> inbox;

    public User(String name) {
        this.name = name;
        friends = new ArrayList<>();
        inbox = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public Queue<String> getInbox() {
        return inbox;
    }

    public void addToInbox(String msg) {
        this.inbox.add(msg);
    }

}
