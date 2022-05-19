package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author vital
 */
public class Server {

    public static final int PORT = 8100;
    private boolean running;

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        running = true;

        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(10_000);//10 sec timeout
            while (running) {
                System.out.println("Waiting for a client ...");
                try {
                    Socket socket = serverSocket.accept();
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

    public void stopServer() {
        System.out.println("Stopping server...");
        running = false;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
