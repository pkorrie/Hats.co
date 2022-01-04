package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee employee);
	int deleteEmployee(int id);
	boolean updateEmployee(Employee employee);
}

