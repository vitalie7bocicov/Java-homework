package commands;

import Model.Network;
import Model.User;
import main.ClientThread;

/**
 *
 * @author vital
 */
public class Friend implements Command {

    private String friend;
    private Network socialNetwork;
    private User user;

    public Friend(String friend, ClientThread clientThread) {
        this.friend = friend;
        this.socialNetwork = clientThread.getNetwork();
        this.user = clientThread.getUser();
    }

    public String run() {

        if (socialNetwork.getUser(friend) == null) {
            return "user " + friend + " does not exist!";
        }

        if (user == socialNetwork.getUser(friend)) {
            return "you can not add yourself to your friend list!";
        }

        if (user.getFriends().contains(socialNetwork.getUser(friend))) {
            return "user " + friend + " is already in your friend list";
        }
        user.getFriends().add(socialNetwork.getUser(friend));
        return "you and " + friend + " are now friends!";
    }
}
