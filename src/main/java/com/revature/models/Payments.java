package com.revature.models;

import java.util.Objects;

public class Payments {
	protected int Id;
	protected int customerId;
	protected int hatId;
	protected double payed;
	protected double remaining;
	
	
	public Payments(int id, int customerId, int hatId, double payed, double remaining) {
		super();
		Id = id;
		this.customerId = customerId;
		this.hatId = hatId;
		this.payed = payed;
		this.remaining = remaining;
		
		
	}


	public Payments(int hatId, double payed) {
		super();
		this.hatId = hatId;
		this.payed = payed;
	}




	public Payments(int id, int hatId, double payed, double remaining) {
		super();
		Id = id;
		this.hatId = hatId;
		this.payed = payed;
		this.remaining = remaining;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getHatId() {
		return hatId;
	}


	public void setHatId(int hatId) {
		this.hatId = hatId;
	}


	public double getPayed() {
		return payed;
	}


	public void setPayed(double payed) {
		this.payed = payed;
	}


	public double getRemaining() {
		return remaining;
	}


	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id, customerId, hatId, payed, remaining);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payments other = (Payments) obj;
		return Id == other.Id && customerId == other.customerId && hatId == other.hatId
				&& Double.doubleToLongBits(payed) == Double.doubleToLongBits(other.payed)
				&& Double.doubleToLongBits(remaining) == Double.doubleToLongBits(other.remaining);
	}


	@Override
	public String toString() {
		return "Payments [Id=" + Id + ", customerId=" + customerId + ", hatId=" + hatId + ", payed=" + payed
				+ ", remaining=" + remaining + "]";
	}
	
	
	
	
}