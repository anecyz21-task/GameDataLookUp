package milestone3.model;

import java.util.Objects;

public class Weapon extends Gear {
	private int jobID;
	private int damage;
	
	public Weapon(int itemID, String itemName, int itemLevel, int itemMax, double itemPrice,
			int requiredLevel, int jobID, int damage) {
		super(itemID, itemName, itemLevel, itemMax, itemPrice, requiredLevel);
		this.jobID = jobID;
		this.damage = damage;
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	

	@Override
	public String toString() {
		return "Weapon [jobID=" + jobID + ", damage=" + damage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 41;
		int result = super.hashCode();
		result = prime * result + Objects.hash(damage, jobID);
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
		Weapon other = (Weapon) obj;
		return damage == other.damage && jobID == other.jobID;
	}
	
	
	

	
	
}