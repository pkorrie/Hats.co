package com.revature.controllers;


import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.exceptions.HatAlreadyExistsException;
import com.revature.exceptions.HatDoesNotExistException;
import com.revature.exceptions.EmployeeDoesNotExistsException;
import com.revature.models.Employee;
import com.revature.models.Hat;
import com.revature.models.Offers;
import com.revature.services.EmployeeService;
import com.revature.services.HatService;
import com.revature.services.OffersService;
import com.revature.services.PaymentService;


public class EmployeeMenu {
	private static HatService hs = new HatService();
	private static EmployeeService es = new EmployeeService();
	private static OffersService os = new OffersService();
	private static PaymentService ps = new PaymentService();
	

	public void addNewHat(Scanner scan) {
		System.out.println("Please enter: ");
		System.out.println("Type: ");
		String type = scan.nextLine();
		System.out.println("Price: ");
		String price1 = scan.nextLine();
		int price = Integer.parseInt(price1);
		System.out.println("Color: ");
		String color = scan.nextLine();
		System.out.println("Size: ");
		String size = scan.nextLine();
		
		Hat newHat = new Hat(type, price, color, size);
		
		try {
			newHat = hs.addHat(newHat);
			System.out.println("Hat has been added!");
		} catch (HatAlreadyExistsException e) {
			System.out.println("Hat already exists");
		}
		
	}
	
	public void removeExitingHat(Scanner scan) {
		List<Hat> hats =hs.getAllHats();
		if(hats != null) {
			for(Hat i : hats) {
				System.out.println(i);
			}
		System.out.println("Please select the hat you would like to delete by Id");
		int id = Integer.parseInt(scan.nextLine());
		
		Hat rmHat = new Hat(id);
		
		try {
			hs.removeHatById(rmHat.getId());
		} catch (HatDoesNotExistException e) {
			e.printStackTrace();
		}
		System.out.println("Hat has been removed!");
	}else {
		System.out.println("No Hats avaliable");
		}
	}
	
	public void removeEmp(Scanner scan) {
		List<Employee> emps = es.getAllEmployee();
		
		if(emps != null) {
			for(Employee i : emps) {
				System.out.println(i);
			}
			System.out.println("Please enter Employee by ID: ");
			int id1 = Integer.parseInt(scan.nextLine());
			Employee rmEmp= new Employee(id1);
		
		try {
			es.deleteEmployee(rmEmp.getId());
		} catch (EmployeeDoesNotExistsException e) {
			e.printStackTrace();
		}
		System.out.println("Employee has been removed!");
	} else {
		System.out.println("No Employees avaliable");
		}
	}
	
	public void addEmp(Scanner scan) {
		System.out.println("Please enter Employee Name: ");
		String name = scan.nextLine();
		System.out.println("Please enter Employee UserName: ");
		String Username = scan.nextLine();
		System.out.println("Please enter Employee password: ");
		String password = scan.nextLine();
		System.out.println("Please enter Employee role: ");
		String role = scan.nextLine();
		
		Employee newEmp = new Employee(name,Username,password,role);
		
		try {
			newEmp = es.addEmployee(newEmp);
			System.out.println("Employee has been added");
		} catch (EmployeeAlreadyExistsException e) {
			System.out.println("Hat already exists");
			}
		
		}
	
	public void AcceptOrReject(Scanner scan) {
		List<Offers> offers = os.getAllPendingOffers();
		if(offers != null) {
			for(Offers i : offers) {
				System.out.println(i);
			}
			System.out.println("Please select the offer by Id");
			int id = Integer.parseInt(scan.nextLine());
			System.out.println("Accept or Reject?");
			String action = scan.nextLine();
			Offers eOff = new Offers(id,action);
			if(action.toLowerCase().trim().equals("accept")) {
				eOff.setAcceptoffer("true");
				os.updateOffer(eOff);
				os.deleteOffer(eOff);
				System.out.println("Offer has been accepted");
			}else if(action.toLowerCase().trim().equals("reject")) {
				
				System.out.println("Offer has been rejected");
				}
			}
		}
		
		public void veiwAllPayment(Scanner scan) {
			System.out.println(ps.viewAllPay());
			
		}
			
	
	
}
