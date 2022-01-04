package com.revature.models;


public class Customer extends User {


	public Customer() {
		super();
	}

	public Customer(int id, String name, String username, String password, String role, Employee manager) {
		super(id, name, username, password, role, manager);
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String username, String password, String role) {
		super(name, username, password, role);
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		
	}


	public Customer(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}




}
