package beer.umajkla.desktop;

import beer.umajkla.model.InventoryItem;

public class ResponseData {
    private InventoryItem item;

    public ResponseData(InventoryItem item) {
        this.item = item;
    }

    public InventoryItem getItem() {
        return item;
    }
}
