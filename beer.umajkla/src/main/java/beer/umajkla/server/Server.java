package beer.umajkla.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public final class Server implements Runnable {
    private ArrayList<ServerThread> clients = new ArrayList<>();
    private ServerSocket server = null;
    private Thread thread = null;
    private boolean consoleAvailable = true;

    public Server(int port) {
        try {
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            start();
        } catch (IOException e) {
            System.out.println("Can not bind to port " + port + ": " + e.getMessage());
        }
    }

    public void run() {
        while (thread != null) {
            try {
                System.out.println("Waiting for a desktop ...");
                addThread(server.accept());
            } catch (IOException e) {
                System.out.println("Server accept error: " + e);
                stop();
            }
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    private ServerThread findClient(String ID) {
        return findClient(UUID.fromString(ID));
    }

    private ServerThread findClient(UUID ID) {
        for (int i = 0; i < clients.size(); i++)
            if (clients.get(i).getID() == ID)
                return clients.get(i);
        return null;
    }

    private int clientPos(UUID ID) {
        for (int i = 0; i < clients.size(); i++)
            if (clients.get(i).getID() == ID)
                return i;
        return -1;
    }

    public synchronized void handle(UUID ID, String input) {
        String[] parts = input.split(" ", 2);
        ServerThread thread = findClient(ID);
        if (parts[0].startsWith("/")) {
            switch (parts[0]) {
                case "/bye":
                    thread.send("/bye");
                    remove(ID);
                    break;
                case "/tell":
                    String[] cmd = parts[1].split(" ", 2);
                    try {
                        ServerThread target = findClient(cmd[0]);
                        if (target != null) target.send(cmd[1]);
                        else thread.send("Client " + cmd[0] + " could not be found");
                    } catch (NumberFormatException e) {
                        thread.send("" + cmd[0] + " is not a valid desktop id");
                    }
                    break;
                case "/kick":
                    if (thread.isConsole()) {
                        try {
                            ServerThread target = findClient(parts[1]);
                            if (target != null) {
                                target.send("/bye");
                                remove(target.getID());
                            } else thread.send("Client " + parts[1] + " could not be found");
                        } catch (NumberFormatException ex) {
                            thread.send(parts[1] + " is not a valid client id");
                        }
                    } else {
                        thread.send("You are not a console and cannot use this command");
                    }
                    break;
                case "/gui":
                    if (thread.isConsole()) {
                        AppletThread appThread = new AppletThread("beer.umajkla.server.AdminApplet");
                        appThread.start();
                    }
                    break;
                case "/broadcast":
                    for (ServerThread client : clients) client.send(ID + ": " + parts[1]);
                    break;
                default:
                    thread.send("This command could not be understood");
            }
        } else {
            for (ServerThread client : clients) client.send(ID + ": " + input);
        }
    }

    public synchronized void remove(UUID ID) {
        int pos = clientPos(ID);
        if (pos >= 0) {
            ServerThread toTerminate = clients.get(pos);
            System.out.println("Removing desktop thread " + ID + " at " + pos);
            if (pos < clients.size()) clients.remove(pos);
            try {
                toTerminate.close();
            } catch (IOException e) {
                System.out.println("Error closing thread: " + e);
            }
            toTerminate.stop();
        }
    }

    private void addThread(Socket socket) {
        System.out.println("Client accepted: " + socket);
        ServerThread thread = new ServerThread(this, socket);
        if (clients.size() == 0 && consoleAvailable) {
            thread.makeConsole();
            consoleAvailable = false;
        }
        clients.add(thread);
        try {
            thread.open();
            thread.start();
            if (thread.isConsole()) thread.send("This client is set as console");
        } catch (IOException e) {
            System.out.println("Error opening thread: " + e);
        }
    }
}
