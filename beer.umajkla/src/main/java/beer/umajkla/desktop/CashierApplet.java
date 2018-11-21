package beer.umajkla.desktop;

import beer.umajkla.ui.Applet;
import processing.event.MouseEvent;

public class CashierApplet extends Applet {
    public void settings() {
        fullScreen();
    }

    public void setup() {
        init();
        stack.push(new LoginView(this));
    }

    public void draw() {
        image(stack.current(), 0, 0);
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
}
