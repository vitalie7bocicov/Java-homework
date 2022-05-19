package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vital
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                 Socket socket = new Socket(serverAddress, PORT);  PrintWriter out
                = new PrintWriter(socket.getOutputStream(), true);  BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
// Send a request to the server
            Scanner input = new Scanner(System.in);
            String cmd;

            while (true) {
                System.out.print("cmd: ");
                cmd = input.nextLine();
                if (cmd.equals("exit")) {
                    System.out.print("exiting...");
                    break;
                }

                out.println(cmd);
                if (cmd.equals("stop")) {
                    System.out.print("exiting...");
                    break;
                }
                String response = in.readLine();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (SocketException e) {
            System.out.println("Connection closed by server!");
        }
    }
}
