package com.revature.services;

import java.util.List;

import com.revature.exceptions.CustomerAlreadyExistsException;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerPostgres;

public class CustomerService {
	
//	private CustomerDao cd = new CustomerList();
	private CustomerDao cd = new CustomerPostgres();
	
	
	public Customer addCustomer(Customer c) throws CustomerAlreadyExistsException {
		Customer newCust = this.getCustomerByUsername(c.getUsername());
		if(newCust != null) {
			throw new CustomerAlreadyExistsException();
		}
//		c.setRole(Roles.Customer);
		return cd.addCustomer(c);
	}


	private Customer getCustomerByUsername(String username) {
		List<Customer> customers = cd.getAllCustomer();
		for(Customer i :customers) {
			if(i.getUsername().equals(username)) {
				return i;
			}
		}
		return null;
	}
	
	public Customer getCustomerById(int id) {
		return cd.getCustomerById(id);
	}
	
	public Customer login(String username, String password) throws LoginException {
		List<Customer> customers = cd.getAllCustomer();
		for(Customer i : customers) {
			if (i.getUsername().equals(username)&& i.getPassword().equals(password)) {
				return i;
			}
		}
		throw new LoginException();
	}
	

}
