package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author vital
 */
class ClientThread extends Thread {

    private Socket socket = null;
    private Server server;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
// Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request = in.readLine();;
            while (request != null) {
                if (request.equals("stop")) {
                    String raspuns = "Server stopped";

                    out.println(raspuns);
                    out.flush();
                    server.stopServer();
                    break;
                }
                String raspuns = "server: executing " + request;
                out.println(raspuns);
                out.flush();
                request = in.readLine();;

            }
// Send the response to the oputput stream: server → client

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
