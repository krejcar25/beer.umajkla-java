package beer.umajkla.server;

import beer.umajkla.ui.Applet;
import beer.umajkla.ui.View.BaseView;
import processing.event.MouseEvent;

public class ConnectionsView extends BaseView {
    ConnectionsView(Applet applet) {
        super(applet);
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

    @Override
    public void update() {
        beginDraw();
        background(0,255,0);
        endDraw();
    }
}
