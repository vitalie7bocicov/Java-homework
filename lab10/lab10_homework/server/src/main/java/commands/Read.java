package commands;

import Model.User;
import java.util.Queue;
import main.ClientThread;

/**
 *
 * @author vital
 */
public class Read implements Command {

    private User user;

    public Read(ClientThread clientThread) {
        this.user = clientThread.getUser();
    }

    @Override
    public String run() {
        Queue<String> inbox = user.getInbox();
        if (inbox.isEmpty()) {
            return "no new messages in your inbox!";
        }
        return inbox.poll();
    }

}
