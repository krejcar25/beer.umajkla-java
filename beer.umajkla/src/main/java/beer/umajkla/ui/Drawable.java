package beer.umajkla.ui;

import processing.awt.PGraphicsJava2D;

public abstract class Drawable extends PGraphicsJava2D {
    protected final Applet applet;

    public Drawable(Applet parent, int sizex, int sizey) {
        this.applet = parent;
        setParent(parent);
        setPrimary(false);
        setPath(parent.dataPath(""));
        setSize(sizex, sizey);

        smooth(4);
        beginDraw();
        fill(-1);
        stroke(0);
        endDraw();
    }

    public abstract void update();
}
