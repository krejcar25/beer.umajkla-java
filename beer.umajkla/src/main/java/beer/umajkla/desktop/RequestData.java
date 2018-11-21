package beer.umajkla.desktop;

import beer.umajkla.model.*;

public class RequestData {
    private InventoryItem item;

    public RequestData(InventoryItem item) {
        this.item = item;
    }

    public InventoryItem getItem() {
        return item;
    }
}
