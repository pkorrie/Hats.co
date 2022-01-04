package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;


public interface CustomerDao {
	List<Customer> getAllCustomer();
	Customer getCustomerById(int id);
	Customer addCustomer(Customer cs); 
	
}
