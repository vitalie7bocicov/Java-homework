package main;

import Model.Network;
import Model.User;
import commands.Command;
import commands.Friend;
import commands.Login;
import commands.Read;
import commands.Send;
import commands.Register;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author vital
 */
public class ClientThread extends Thread {

    private Socket socket = null;
    private Server server;
    private User user = null;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public Network getNetwork() {
        return server.getNetwork();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getCommand(String request) {
        int space = request.indexOf(" ");
        if (space == -1) {
            return request;
        }
        return request.substring(0, space);
    }

    public String getParam(String request, int index) {
        int space = request.indexOf(" ");
        if (space == -1) {
            return "";
        }
        return request.substring(index + 1);
    }

    public String checkCommand(PrintWriter out, String request) {
        String response = "";
        String cmd = getCommand(request);
        String param = getParam(request, cmd.length());
        System.out.println("command: " + cmd);
        System.out.println("param: " + param);
        switch (cmd) {
            case "register":
                if (user != null) {
                    return "please logout first!";
                }
                Command register = new Register(param, this);
                response = register.run();
                break;
            case "login":
                if (user != null) {
                    return "already logged in!";
                }
                Command login = new Login(param, this);
                response = login.run();
                break;
            case "friend":
                if (user == null) {
                    return "please login first!";
                }

                String[] friends = param.split(" ");
                for (String friend : friends) {
                    Command friendCommand = new Friend(friend, this);

                    response += friendCommand.run() + "  |  ";
                    System.out.println(response);
                }

                break;
            case "message":
                if (user == null) {
                    return "please login first!";
                }
                Command send = new Send(param, this);
                response = send.run();
                break;
            case "read":
                if (user == null) {
                    return "please login first!";
                }
                Command read = new Read(this);
                response = read.run();
                break;
            case "logout":
                if (user == null) {
                    return "already logged out!";
                }

                user = null;

                response = "logout successful!";
                break;

            default:
                response = "command not found";
        }

        return response;

    }

    public boolean checkStop(PrintWriter out, String request) {
        if (request.equals("stop")) {
            String raspuns = "Server stopped";
            out.println(raspuns);
            out.flush();
            server.stopServer();
            return true;
        }
        String response = "server: " + checkCommand(out, request);;
        out.println(response);
        out.flush();

        return false;
    }

    @Override
    public void run() {
        try {
// Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request = in.readLine();
            boolean stopped = false;
            while (request != null) {
                stopped = checkStop(out, request);
                if (stopped) {
                    break;
                }
                request = in.readLine();
                System.out.println("request:" + request);
            }
// Send the response to the oputput stream: server → client

        } catch (IOException e) {
            System.err.println("Connection closed: " + e);

        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
