package beer.umajkla.server;

import beer.umajkla.client.Client;
import beer.umajkla.ui.*;
import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption(Option.builder("nogui").longOpt("nogui").required(false).build());
        CommandLine cmd = null;

        try {
            cmd = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }

        int port = 3000;
        Server server = new Server(port);
        System.out.println("Server is really running");
        Client client = new Client("localhost", port);

        if (!cmd.hasOption("nogui")) Applet.main("beer.umajkla.server.AdminApplet");
    }
}
