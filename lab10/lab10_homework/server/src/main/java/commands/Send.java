package commands;

import Model.Network;
import Model.User;
import main.ClientThread;

/**
 *
 * @author vital
 */
public class Send implements Command {

    private String message;
    private User user;

    public Send(String message, ClientThread clientThread) {
        this.message = message;
        this.user = clientThread.getUser();

    }

    @Override
    public String run() {
        if (message.isBlank()) {
            return "the message cannot be empty!";
        }

        if (user.getFriends().isEmpty()) {
            return "please add friends first!";
        }
        message = user.getName() + ": " + message;

        for (User friend : user.getFriends()) {
            friend.addToInbox(message);
        }

        return "message sent to all your friends!";
    }
}
