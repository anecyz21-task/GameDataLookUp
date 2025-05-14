package milestone3.model;

import java.util.Objects;

public class Inventory {
    private int characterId;
    private int slotId;
    private int itemId;
    private int quantity;

    public Inventory(int characterId, int slotId, Integer itemId, int quantity) {
        this.characterId = characterId;
        this.slotId = slotId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return characterId == inventory.characterId &&
                slotId == inventory.slotId &&
                quantity == inventory.quantity &&
                Objects.equals(itemId, inventory.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, slotId, itemId, quantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "characterId=" + characterId +
                ", slotId=" + slotId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
