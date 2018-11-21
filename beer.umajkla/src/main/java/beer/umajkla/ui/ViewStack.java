package beer.umajkla.ui;

import beer.umajkla.ui.View.BaseView;
import processing.core.PApplet;

import java.util.ArrayList;

public class ViewStack {
    private ArrayList<BaseView> list;
    private PApplet applet;

    public ViewStack(PApplet applet) {
        this.applet = applet;
        list = new ArrayList<>();
    }

    public void push(BaseView item) {
        list.add(item);
    }

    public BaseView current() {
        BaseView v = list.get(list.size() - 1);
        v.update();
        return v;
    }

    public BaseView pop() {
        BaseView v = list.get(list.size() - 1);
        list.remove(v);
        return v;
    }
}
