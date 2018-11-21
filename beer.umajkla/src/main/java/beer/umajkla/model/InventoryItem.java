package beer.umajkla.model;

import java.util.UUID;

public class InventoryItem implements ShopObject {
    private UUID id;
    private UUID owner;
    private String name;

    public InventoryItem() {

    }

    public UUID getId() {
        return id;
    }

    public UUID getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
