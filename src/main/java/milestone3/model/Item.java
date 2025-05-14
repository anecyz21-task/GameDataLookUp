package milestone3.model;

import java.util.Objects;

public class Item {
	private int itemID;
	private String itemName;
	private int itemLevel;
	private int itemMax;
	private double itemPrice;
	
	public Item(int itemID, String itemName, int itemLevel, int itemMax, double itemPrice) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemLevel = itemLevel;
		this.itemMax = itemMax;
		this.itemPrice = itemPrice;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}

	public int getItemMax() {
		return itemMax;
	}

	public void setItemMax(int itemMax) {
		this.itemMax = itemMax;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemLevel=" + itemLevel + ", itemMax=" + itemMax
				+ ", itemPrice=" + itemPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemID, itemLevel, itemMax, itemName, itemPrice) * 13;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemID == other.itemID && itemLevel == other.itemLevel && itemMax == other.itemMax
				&& Objects.equals(itemName, other.itemName)
				&& Double.doubleToLongBits(itemPrice) == Double.doubleToLongBits(other.itemPrice);
	}
	
	
	
	
}