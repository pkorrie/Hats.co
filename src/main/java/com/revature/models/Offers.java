package com.revature.models;

import java.util.Objects;

public class Offers {
	protected int Id;
	protected int customerId;
	protected int hatId;
	protected double offer;
	protected String acceptoffer;
	
	
	

	public Offers(int id, int customerId, int hatId, double offer, String acceptoffer) {
		super();
		Id = id;
		this.customerId = customerId;
		this.hatId = hatId;
		this.offer = offer;
		this.acceptoffer = acceptoffer;
	}



	public Offers(int hatId, double offer) {
		super();
		this.hatId = hatId;
		this.offer = offer;
	}



	public Offers(int id, int customerId, int hatId, double offer) {
		super();
		Id = id;
		this.customerId = customerId;
		this.hatId = hatId;
		this.offer = offer;
	}







	public Offers(int id) {
		super();
		Id = id;
	}



	



	public Offers(int id, String acceptoffer) {
		super();
		Id = id;
		this.acceptoffer = acceptoffer;
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




	public double getOffer() {
		return offer;
	}




	public void setOffer(double offer) {
		this.offer = offer;
	}




	public String getAcceptoffer() {
		return acceptoffer;
	}




	public void setAcceptoffer(String acceptoffer) {
		this.acceptoffer = acceptoffer;
	}




	@Override
	public int hashCode() {
		return Objects.hash(Id, acceptoffer, customerId, hatId, offer);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offers other = (Offers) obj;
		return Id == other.Id && Objects.equals(acceptoffer, other.acceptoffer) && customerId == other.customerId
				&& hatId == other.hatId && Double.doubleToLongBits(offer) == Double.doubleToLongBits(other.offer);
	}




	@Override
	public String toString() {
		return "Offers [Id=" + Id + ", customerId=" + customerId + ", hatId=" + hatId + ", offer=" + offer
				+ ", acceptoffer=" + acceptoffer + "]";
	}
	
	




	
	
}
