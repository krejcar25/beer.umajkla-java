package beer.umajkla.desktop;

import beer.umajkla.ui.*;
import beer.umajkla.ui.View.BaseView;
import processing.event.MouseEvent;

public class LoginView extends BaseView {
    LoginView(Applet parent) {
        super(parent);
    }

    @Override
    public void update() {
        beginDraw();
        background(255, 0, 0);
        endDraw();
    }

    @Override
    public void click(int mx, int my, boolean rmb) {

    }

    @Override
    public void mouseDrag(int mx, int my) {

    }

    @Override
    public void scroll(MouseEvent event) {

    }

    @Override
    public void keyDown(char key, int keyCode) {

    }

    @Override
    public void keyUp(char key, int keyCode) {

    }
}
