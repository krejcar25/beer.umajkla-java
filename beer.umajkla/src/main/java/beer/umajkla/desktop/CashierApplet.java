package beer.umajkla.desktop;

import beer.umajkla.ui.Applet;
import processing.event.MouseEvent;

public class CashierApplet extends Applet {

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        init();
        stack.push(new LoginView(this));
    }

    @Override
    public void draw() {
        image(stack.current(), 0, 0);
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
}
