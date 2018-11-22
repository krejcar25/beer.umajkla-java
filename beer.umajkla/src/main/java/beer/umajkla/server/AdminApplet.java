package beer.umajkla.server;

import beer.umajkla.ui.Applet;
import processing.event.MouseEvent;

public class AdminApplet extends Applet {

    public void settings() {
        fullScreen();
    }

    public void setup() {
        init();
        stack.push(new ConnectionsView(this));
    }

    public void draw() {

    }

    protected void click(MouseEvent event) {

    }

    protected void mouseDown(MouseEvent event) {

    }

    protected void mouseUp(MouseEvent event) {

    }

    protected void mouseDrag(MouseEvent event) {

    }

    protected void scroll(MouseEvent event) {

    }

    protected void keyDown(char key, int keyCode) {

    }

    protected void keyUp(char key, int keyCode) {

    }

    public void run() {
        main("beer.umajkla.server.AdminApplet");
    }

    public void exitActual() {
        try {
            closeWindow();
        } catch (SecurityException e) {
            // We still don't care
        }
    }
}
