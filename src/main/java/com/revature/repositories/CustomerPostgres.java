package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;


import util.ConnectionUtil;

public class CustomerPostgres implements CustomerDao {

	@Override
	public List<Customer> getAllCustomer() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				String username = rs.getString("c_username");
				String password = rs.getString("c_password");
				
				Customer newCust = new Customer(id, name, username, password);
				customers.add(newCust);
			}
			
			} catch (SQLException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "select * from customers where c_id = ? ";
		Customer cust = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int e_id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				String e_username = rs.getString("c_username");
				String e_password = rs.getString("c_password");
				
				cust = new Customer(e_id, name, e_username, e_password);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public Customer addCustomer(Customer cs) {
		Customer resultId= null;
		String sql = "insert into customers (c_name, c_username, c_password) "
				+ "values (?, ?, ?) returning c_id;";
		

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cs.getName());
			ps.setString(2, cs.getUsername());
			ps.setString(3, cs.getPassword());


			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = cs;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return resultId;
	}

	

}
