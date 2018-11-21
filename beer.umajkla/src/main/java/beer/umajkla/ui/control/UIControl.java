package beer.umajkla.ui.control;

import beer.umajkla.ui.Applet;
import beer.umajkla.ui.Drawable;

public abstract class UIControl extends Drawable {
    protected int x;
    protected int y;

    public UIControl(Applet parent, int sizex, int sizey) {
        super(parent, sizex, sizey);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
