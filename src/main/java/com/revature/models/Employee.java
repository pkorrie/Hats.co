package com.revature.models;


public class Employee extends User{

	private String emp;
	private int man_id;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String username, String password, String role, Employee manager) {
		super(id, name, username, password, role, manager);
	}

	public Employee(String name, String username, String password, String role) {
		super(name, username, password, role);
	}

	public Employee(int id, String name, String username, String password, String role, int man_id) {
		super( name, username, password, role );
		this.man_id = man_id;
		this.id = id;
	}

	public Employee(String emp) {
		this.emp =emp;
	}

	

	public Employee(int id) {
		this.id = id;
	}
	
//	public Employee( String name, String username, String password, String role, Employee manager) {
//		super(name, username, password, role, manager);
//		
//	}
	
	public Employee( String name, String username, String password, String role, int man_id) {
		super( name, username, password, role );
		this.man_id = man_id;
	}


	

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public int getMan_id() {
		return man_id;
	}

	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}

	

}

	

	