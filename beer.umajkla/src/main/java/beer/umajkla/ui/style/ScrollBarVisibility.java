package beer.umajkla.ui.style;

public enum ScrollBarVisibility {
    Visible,
    Hidden,
    Automatic;

    public boolean showScrollBar(int v, int c) {
        switch (this) {
            case Visible:
                return true;
            case Hidden:
                return false;
            case Automatic:
                return c > v;
            default:
                return false;
        }
    }
}
