package beer.umajkla.ui.View;

import beer.umajkla.ui.Applet;
import processing.core.*;
import beer.umajkla.ui.style.*;

@SuppressWarnings("WeakerAccess")
public abstract class ScrollView extends BaseView {
    protected PGraphics content;

    public int horizontalScrollBarWidth = 5;
    public ScrollBarVisibility horizontalScrollBarVisibility = ScrollBarVisibility.Automatic;
    public Color horizontalScrollBarColor = new Color(51);

    public ScrollBarVisibility verticalScrollBarVisibility = ScrollBarVisibility.Automatic;
    public int verticalScrollBarWidth = 5;
    public Color verticalScrollBarColor = new Color(51);

    public int horizontalScroll = 0;
    public int verticalScroll = 0;

    public int scrollSpeed = 30;

    private int hScrollO = -1;
    private int vScrollO = -1;

    protected ScrollView(Applet parent, int sizex, int sizey) {
        super(parent, sizex, sizey);
    }

    @Override
    public void update() {
        boolean showH = horizontalScrollBarVisibility.showScrollBar(width, content.width);
        boolean showV = verticalScrollBarVisibility.showScrollBar(height, content.height);

        beginDraw();
        background(220);
        image(content.get(horizontalScroll, verticalScroll, width - (showV ? verticalScrollBarWidth : 0), height - (showH ? horizontalScrollBarWidth : 0)), 0, 0);
        push();
        noStroke();

        if (showH) {
            push();
            translate(0, height - horizontalScrollBarWidth);
            fill(horizontalScrollBarColor.r, horizontalScrollBarColor.g, horizontalScrollBarColor.b);
            float r = (((float) width) / content.width);
            rect(horizontalScroll * r, 0, (width - (showV ? verticalScrollBarWidth : 0)) * r, horizontalScrollBarWidth);
            pop();
        }

        if (showV) {
            push();
            translate(width - verticalScrollBarWidth, 0);
            fill(verticalScrollBarColor.r, verticalScrollBarColor.g, verticalScrollBarColor.b);
            float r = (((float) height) / content.height);
            rect(0, verticalScroll * r, verticalScrollBarWidth, (height - (showH ? horizontalScrollBarWidth : 0)) * r);
            pop();
        }

        pop();
        //if (overlay != null) content.image(overlay.show(), overlay.x, overlay.y);
        endDraw();
    }

    @Override
    public void keyDown(char key, int keyCode) {
        int x = 0;
        int y = 0;

        if (applet.isKeyPressed(Applet.UP)) y += -scrollSpeed;
        if (applet.isKeyPressed(Applet.RIGHT)) x += scrollSpeed;
        if (applet.isKeyPressed(Applet.DOWN)) y += scrollSpeed;
        if (applet.isKeyPressed(Applet.LEFT)) x += -scrollSpeed;

        scroll(x, y);
    }

    public void scroll(float x, float y) {
        horizontalScroll = Applet.floor(Applet.constrain(horizontalScroll + x, 0, content.width - width));
        verticalScroll = Applet.floor(Applet.constrain(verticalScroll + y, 0, content.height - height));
    }

    @Override
    public void mouseDown(int mx, int my, boolean rmb) {
        super.mouseDown(mx, my, rmb);
        hScrollO = horizontalScroll;
        vScrollO = verticalScroll;
    }

    @Override
    public void mouseDrag(int mx, int my) {
        horizontalScroll = Applet.constrain(hScrollO - (mx - mousePressX), 0, content.width - width);
        verticalScroll = Applet.constrain(vScrollO - (my - mousePressY), 0, content.height - height);
    }
}
