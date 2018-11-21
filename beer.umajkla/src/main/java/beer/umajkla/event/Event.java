package beer.umajkla.event;

import java.util.ArrayList;

public class Event<E extends EventHandler> {
    private ArrayList<E> handlers;
    private Class argsType;

    public <E> Event() {
        handlers = new ArrayList<>();
    }

    public Event<E> add(E handler) {
        handlers.add(handler);
        return this;
    }

    public Event<E> remove(E handler) {
        handlers.remove(handler);
        return this;
    }

    public void invoke(Object sender, EventArgs e) {
        for (E handler : handlers) {
            handler.fire(sender, e);
        }
    }
}
