package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDao;
import com.revature.services.EmployeeService;

@ExtendWith(MockitoExtension.class)

public class EmployeeServiceTest{
	
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;
	
	@Test	
	public void addEmployeeTestValid() {
	Employee emp = new Employee("name","username","password","employee",1);
		
		Mockito.when(ed.addEmployee(new Employee("name","username","password","employee",1))).thenReturn(emp);
		
		Employee expected = new Employee("name","username","password","employee", 1);
		
		Employee actual;
		try {
			actual = es.addEmployee(new Employee("name","username","password","employee", 1));
			assertEquals(expected, actual);
		} catch (EmployeeAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}