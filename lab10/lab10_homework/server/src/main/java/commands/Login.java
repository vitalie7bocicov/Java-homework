package commands;

import Model.Network;
import main.ClientThread;

/**
 *
 * @author vital
 */
public class Login implements Command {

    private String username;
    private Network socialNetwork;
    private ClientThread clientThread;

    public Login(String username, ClientThread clientThread) {
        this.username = username;
        this.socialNetwork = clientThread.getNetwork();
        this.clientThread = clientThread;
    }

    public String run() {

        if (socialNetwork.getUser(username) == null) {
            return "The username you entered does not exist";
        }
        clientThread.setUser(socialNetwork.getUser(username));
        return "login successful! ";
    }

}
