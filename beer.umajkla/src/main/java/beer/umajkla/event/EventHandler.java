package beer.umajkla.event;

public interface EventHandler<EA extends EventArgs> {
    void fire(Object sender, EA e);
}
