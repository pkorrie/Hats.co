package com.revature.repositories;

//import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
//import com.revature.models.Roles;

public class CustomerList implements CustomerDao {
	private List<Customer> customers;

	public CustomerList() {
//		customers = new ArrayList<>();
//		Customer jake= new Customer(0, "jake", "jk", "jPass", Roles.Customer);
//		customers.add(jake);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		for (Customer c : customers) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Customer addCustomer(Customer cs) {
		cs.setId(customers.size());
		customers.add(cs);
		for (Customer i : customers) {
			if(i.getId() == cs.getId()) {
				return cs;
			}
		}
		return null;
	}





	

}
