package milestone3.model;

import java.util.Objects;

public class Gear extends Item{
	private int requiredLevel;
	
	public Gear(int itemID, String itemName, int itemLevel, int itemMax, double itemPrice,
			int requiredLevel) {
		super(itemID, itemName, itemLevel, itemMax, itemPrice);
		this.requiredLevel = requiredLevel;
	}


	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	@Override
	public String toString() {
		return "Gear [requiredLevel=" + requiredLevel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 21;
		int result = super.hashCode();
		result = prime * result + Objects.hash(requiredLevel);
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
		Gear other = (Gear) obj;
		return requiredLevel == other.requiredLevel;
	}
	
	
}