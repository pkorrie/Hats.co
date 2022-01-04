package com.revature.models;

import java.util.Objects;

public class Subscribe {
	protected int id;
	protected int subscriber;

	
	
	
	
	
	public Subscribe(int subscriber) {
		super();
		this.subscriber = subscriber;
	}



	public Subscribe(int id, int subscriber) {
		super();
		this.id = id;
		this.subscriber = subscriber;
	}
	
	



	public Subscribe() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(int subscriber) {
		this.subscriber = subscriber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, subscriber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscribe other = (Subscribe) obj;
		return id == other.id && subscriber == other.subscriber;
	}
	@Override
	public String toString() {
		return "Subscribe [id=" + id + ", subscriber=" + subscriber + "]";
	}
	
	
	
	
}
