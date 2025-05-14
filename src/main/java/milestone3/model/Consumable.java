package milestone3.model;

import java.util.Objects;

public class Consumable extends Item{
	private String description;
	
	
	public Consumable(int itemID, String itemName, int itemLevel, int itemMax, double itemPrice,
			String description) {
		super(itemID, itemName, itemLevel, itemMax, itemPrice);
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Consumable [ description=" + description + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumable other = (Consumable) obj;
		return Objects.equals(description, other.description);
	}
}
