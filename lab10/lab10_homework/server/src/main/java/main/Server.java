package main;

import Model.Network;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sun.tools.javac.Main;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vital
 */
public class Server {

    public static final int PORT = 8100;
    private boolean running;
    Network socialNetwork;
    private int serverTimeout = 30_000;//sec
    private int clientTimeout = 20_000;

    public Server() throws IOException {
        this.transferFile();
        ServerSocket serverSocket = null;
        running = true;
        socialNetwork = new Network();
        try {

            serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(serverTimeout);
            while (running) {
                System.out.println("Waiting for a client ...");
                try {
                    Socket socket = serverSocket.accept();
                    socket.setSoTimeout(clientTimeout);
                    new ClientThread(socket, this).start();
                } catch (SocketTimeoutException e) {
                    System.err.println("time expired!");
                }
// Execute the client's request in a new thread

            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public Network getNetwork() {
        return this.socialNetwork;
    }

    public void stopServer() {
        System.out.println("Shutting down the server...");
        running = false;
    }

    public void transferFile() {
        JSchUtil util = new JSchUtil();
        try {
            util.uploadFile();
        } catch (JSchException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SftpException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {

        Server server = new Server();

    }
}
