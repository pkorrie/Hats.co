package com.revature.models;

import java.util.Objects;

public class User {
	
	protected int id;
	protected String name;
	protected String username;
	protected String password;
	protected String role;
//	protected Roles role;
	protected Employee manager;

	public User() {
		super();
	}

	
	

	public User(int id, String name, String username, String password, String role, Employee manager) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.manager = manager;
	}
	
	public User(String name, String username, String password, String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}




	public User(String name, String username, String password, String role, Employee manager) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.manager = manager;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public Employee getManager() {
		return manager;
	}




	public void setManager(Employee manager) {
		this.manager = manager;
	}




	public int getManagerId() {
		return manager.getId();
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, manager, name, password, role, username);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(manager, other.manager) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
				+ role + ", manager=" + manager + "]";
	}
	
	
}




	