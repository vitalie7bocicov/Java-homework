package commands;

import Model.Network;
import Model.User;
import main.ClientThread;

/**
 *
 * @author vital
 */
public class Register implements Command {

    private String username;
    private Network socialNetwork;
    private ClientThread clientThread;

    public Register(String username, ClientThread clientThread) {
        this.username = username;
        this.socialNetwork = clientThread.getNetwork();
        this.clientThread = clientThread;
    }

    public String run() {
        User user = new User(username);
        return socialNetwork.addUser(user);

    }
}
