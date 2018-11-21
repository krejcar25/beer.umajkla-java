package beer.umajkla.desktop;

import beer.umajkla.client.Client;
import beer.umajkla.ui.*;
import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption(Option.builder("m").longOpt("mode").hasArg(true).required().desc("The program mode. Can be either cashier, pickup or graph").build());
        CommandLine cmd = null;
        try {
            cmd = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }
        switch (cmd.getOptionValue("mode")) {
            case "cashier":
                Applet.main("beer.umajkla.desktop.CashierApplet");
                break;
            case "pickup":
                Client client = new Client("localhost", 3000);
                break;
            case "graph":
                System.out.println("Module not yet supported...");
                System.exit(0);
                break;
            default:
                System.out.println("Mode flag could not be understood...");
                System.exit(1);
        }
    }
}
