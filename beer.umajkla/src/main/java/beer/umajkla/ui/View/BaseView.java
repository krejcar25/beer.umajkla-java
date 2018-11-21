package beer.umajkla.ui.View;

import beer.umajkla.ui.Applet;
import beer.umajkla.ui.Drawable;
import beer.umajkla.ui.MouseButton;
import processing.event.MouseEvent;

public abstract class BaseView extends Drawable {
    protected int mousePressX = -1;
    protected int mousePressY = -1;
    MouseButton mouseButton = MouseButton.None;

    public BaseView(Applet applet) {
        super(applet, applet.width, applet.height);
    }

    protected BaseView(Applet applet, int sizex, int sizey) {
        super(applet, sizex, sizey);
    }

    protected void push() {
        pushMatrix();
        pushStyle();
    }

    protected void pop() {
        popStyle();
        popMatrix();
    }

    public void mouseDown(int mx, int my, boolean rmb) {
        mousePressX = mx;
        mousePressY = my;
        mouseButton = rmb ? MouseButton.Right : MouseButton.Left;
    }

    public void mouseUp(int mx, int my) {
        mousePressX = -1;
        mousePressY = -1;
        mouseButton = MouseButton.None;
    }

    public abstract void click(int mx, int my, boolean rmb);

    public abstract void mouseDrag(int mx, int my);

    public abstract void scroll(MouseEvent event);

    public abstract void keyDown(char key, int keyCode);

    public abstract void keyUp(char key, int keyCode);
}
