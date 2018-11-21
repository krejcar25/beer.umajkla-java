package beer.umajkla.client;

import java.io.*;
import java.net.*;
import java.util.UUID;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Client client = null;
    private DataInputStream streamIn = null;
    private UUID ID;

    public ClientThread(Client _client, Socket _socket) {
        client = _client;
        socket = _socket;
        open();
        start();
    }

    public void open() {
        try {
            streamIn = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error getting input stream: " + e);
            client.stop();
        }
    }

    public void close() {
        try {
            if (streamIn != null) streamIn.close();
        } catch (IOException e) {
            System.out.println("Error closing input stream: " + e);
        }
    }

    public UUID getID() {
        return ID;
    }

    public void run() {
        while (true) {
            try {
                String message = streamIn.readUTF();
                if (message.startsWith("clientId:")) ID = UUID.fromString(message.replaceFirst("clientId:", ""));
                else client.handle(message);
            } catch (IOException e) {
                System.out.println("Listening error: " + e.getMessage());
                client.stop();
            }
        }
    }
}
