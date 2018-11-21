package beer.umajkla.ui;

import processing.core.PApplet;
import processing.event.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Applet extends PApplet {
    protected ViewStack stack;
    private ArrayList<Character> keysPressed;
    private ArrayList<Integer> keyCodesPressed;

    protected void init() {
        stack = new ViewStack(this);
        keysPressed = new ArrayList<>();
        keyCodesPressed = new ArrayList<>();
    }

    protected void push() {
        pushMatrix();
        pushStyle();
    }

    protected void pop() {
        popStyle();
        popMatrix();
    }

    public final void mouseClicked(MouseEvent event) {
        stack.current().click(event.getX(), event.getY(), event.getButton() == RIGHT);
        click(event);
    }

    public final void mousePressed(MouseEvent event) {
        stack.current().mouseDown(event.getX(), event.getY(), event.getButton() == RIGHT);
        mouseDown(event);
    }

    public final void mouseReleased(MouseEvent event) {
        stack.current().mouseUp(event.getX(), event.getY());
        mouseUp(event);
    }

    public final void mouseDragged(MouseEvent event) {
        stack.current().mouseDrag(event.getX(), event.getY());
        mouseDrag(event);
    }

    public final void mouseWheel(MouseEvent event) {
        stack.current().scroll(event);
        scroll(event);
    }

    public final void keyPressed() {
        keysPressed.add(key);
        keyCodesPressed.add(keyCode);
        keyDown(key, keyCode);
        stack.current().keyDown(key, keyCode);
    }

    public final void keyReleased() {
        keysPressed.removeAll(Collections.singletonList(key));
        keyCodesPressed.removeAll(Collections.singletonList(keyCode));
        keyUp(key, keyCode);
        stack.current().keyUp(key, keyCode);
    }

    public boolean isKeyPressed(char key) {
        return keysPressed.contains(key);
    }

    public boolean isKeyPressed(int keyCode) {
        return keyCodesPressed.contains(keyCode);
    }

    protected abstract void click(MouseEvent event);
    protected abstract void mouseDown(MouseEvent event);
    protected abstract void mouseUp(MouseEvent event);
    protected abstract void mouseDrag(MouseEvent event);
    protected abstract void scroll(MouseEvent event);
    protected abstract void keyDown(char key, int keyCode);
    protected abstract void keyUp(char key, int keyCode);
}
