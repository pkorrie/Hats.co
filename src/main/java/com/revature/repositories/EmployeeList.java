package com.revature.repositories;

//import java.util.ArrayList;
import java.util.List;


import com.revature.models.Employee;
//import com.revature.models.Roles;

public class EmployeeList implements EmployeeDao{
	private List<Employee> employees;
	
	public EmployeeList() {
//		employees = new ArrayList<>();
//		Employee System = new Employee(0, "System", "System", "SysPass", System, 0 );
//		employees.add(System);
//		Employee emp = new Employee(1, "pat", "pk", "pkk", Roles.Empolyee,0);
//		employees.add(emp);
	}
	
	


	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	
	@Override
	public Employee getEmployeeById(int id) {
//		for (Employee e : employees) {
//			if (e.getId() == id) {
//				return e;
//				}
//			}
		return null;
		}



	@Override
	public Employee addEmployee(Employee em) {
		em.setId(employees.size());
		// add method returns true if adding to a collection was successful
		employees.add(em);
//		for (Employee i : employees) {
//			if(i.getId() == em.getId()) {
//				return em;
//			}
//		}
		return em;
	}




	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

	