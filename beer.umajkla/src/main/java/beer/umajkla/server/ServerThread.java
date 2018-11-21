package beer.umajkla.server;

import java.io.*;
import java.net.*;
import java.util.UUID;

public class ServerThread extends Thread {
    private Server server = null;
    private Socket socket = null;
    private UUID ID;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;
    private boolean console = false;

    public ServerThread(Server _server, Socket _socket) {
        super();
        server = _server;
        socket = _socket;
        ID = UUID.randomUUID();
    }

    public boolean isConsole() {
        return console;
    }

    public void makeConsole() {
        console = true;
    }

    public void send(String msg) {
        try {
            streamOut.writeUTF(msg);
            streamOut.flush();
        } catch (IOException e) {
            System.out.println(ID + " ERROR sending: " + e.getMessage());
            server.remove(ID);
            stop();
        }
    }

    public UUID getID() {
        return ID;
    }

    public void run() {
        System.out.println("Server Thread " + ID + " running.");
        while (true) {
            try {
                server.handle(ID, streamIn.readUTF());
            } catch (IOException e) {
                System.out.println(ID + " ERROR reading: " + e.getMessage());
                server.remove(ID);
                stop();
            }
        }
    }

    public void open() throws IOException {
        streamIn = new DataInputStream(new
                BufferedInputStream(socket.getInputStream()));
        streamOut = new DataOutputStream(new
                BufferedOutputStream(socket.getOutputStream()));
    }

    public void close() throws IOException {
        if (socket != null) socket.close();
        if (streamIn != null) streamIn.close();
        if (streamOut != null) streamOut.close();
    }
}
