package beer.umajkla.server;

import beer.umajkla.ui.Applet;

public class AppletThread extends Thread {
    private final String mainClass;

    public AppletThread(String mainClass) {
        this.mainClass = mainClass;
    }

    public void run() {
        Applet.main(mainClass);
    }
}
