package beer.umajkla.server;

import beer.umajkla.ui.Applet;
import processing.event.MouseEvent;

public class AdminApplet extends Applet {

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        init();
        stack.push(new ConnectionsView(this));
    }

    @Override
    public void draw() {

    }

    @Override
    protected void click(MouseEvent event) {

    }

    @Override
    protected void mouseDown(MouseEvent event) {

    }

    @Override
    protected void mouseUp(MouseEvent event) {

    }

    @Override
    protected void mouseDrag(MouseEvent event) {

    }

    @Override
    protected void scroll(MouseEvent event) {

    }

    @Override
    protected void keyDown(char key, int keyCode) {

    }

    @Override
    protected void keyUp(char key, int keyCode) {

    }

    public void run() {
        main("beer.umajkla.server.AdminApplet");
    }

    @Override
    public void exitActual() {
        try {
            closeWindow();
        } catch (SecurityException e) {
            // We still don't care
        }
    }
}
