package com.revature.controllers;


import java.util.Scanner;

import com.revature.exceptions.CustomerAlreadyExistsException;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;




public class EntryController {
	private static FrontController fc = new FrontController();
	private CustomerService cs = new CustomerService();
	private EmployeeService es = new EmployeeService();
	int role;
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cm = new CustomerMenu();
	
	
	
	public void register(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
			Customer newCustomer = new Customer(name, username,password);
			
			try {
				newCustomer = cs.addCustomer(newCustomer);
				System.out.println("Registeration Successful!");
			} catch (CustomerAlreadyExistsException e) {
				System.out.println("Username is already in use.\nPlease try again.");
			}
		}
	
	public void Login(Scanner scan) {
		System.out.println("Customer 1 or Employee 2, or Manager 3: ");
		 role = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println();
		
		if (role == 1) {
			
			try {
				Customer login =  cs.login(username, password);
				System.out.println("Welcome " + login.getName() + "!");
				CustomerMenu(scan);
				
			} catch (LoginException l) {
				System.out.println("Username or password is invalid. Please try again.");
			}
			}else if (role == 2){
				
				try {
					Employee login =  es.login(username, password);
					System.out.println("Welcome " + login.getName() + "!");
					EmployeeMenu(scan);
				} catch (LoginException l) {
					System.out.println("Username or password is invalid. Please try again.");
				}
			}else if (role == 3){
				try {
					Employee login =  es.login(username, password);
					System.out.println("Welcome " + login.getName() + "!");
					ManagerMenu(scan);
				} catch (LoginException l) {
					System.out.println("Username or password is invalid. Please try again.");
				}
			}
	}
	
	public static void EmployeeMenu(Scanner scan) {
		boolean home = false;
		while(home == false) {
			System.out.println("What would you like to do:");
			System.out.println("1, Add a hat");
			System.out.println("2, Accept or Reject a pending offer");
			System.out.println("3, Remove a hat");
			System.out.println("4, edit a hat");
			System.out.println("5, View all payments");
			System.out.println("6, Back to home menu");
			
			String choice = scan.nextLine();
			
			
			switch(choice) {
			case "1":
				em.addNewHat(scan);
				System.out.println();
				break;
			case "2":
				em.AcceptOrReject(scan);
				break;
			case "3":
				em.removeExitingHat(scan);
				System.out.println();
				break;
			case "4":
				System.out.println();
				break;
			case "5":
				em.veiwAllPayment(scan);
				System.out.println();
				break;
			case "6":
				fc.run();
				break;
			default:
				System.out.println("Invalid input.");
				}
			}
		}
	
	public static void ManagerMenu(Scanner scan) {
		System.out.println("What would you like to do:");
		System.out.println("1,  view sales history of all offers");
		System.out.println("2, Add an Employee");
		System.out.println("3, remove an Employee");
		System.out.println("4, Back to home menu");
		
		String choice = scan.nextLine();
		
		
		switch(choice) {
		case "1":
			System.out.println();
			break;
		case "2":
			em.addEmp(scan);
			System.out.println();
			break;
		case "3":
			em.removeEmp(scan);
			System.out.println();
			break;
		case "4":
			fc.run();
			break;
		default:
			System.out.println("Invalid input.");
			}
		
	}
	
	public static void CustomerMenu(Scanner scan) {
		boolean home1 = false;
		while(home1 == false) {
		System.out.println("1, View available hats");
		System.out.println("2, Make an offer for a hat");
		System.out.println("3, View your hats");
		System.out.println("4, View remaining payments for a hat");
		System.out.println("5, Make a payment");
		System.out.println("6, Subscribe to KoHats");
		System.out.println("7, Back to home menu");
		
		String choice1 = scan.nextLine();
		
		
		switch(choice1) {
		case "1":
			cm.viewAllAvaliableHats(scan);
			System.out.println();
			break;
		case "2":
			cm.makeOffer(scan);
			break;
		case "3":
			cm.viewOwnedHats(scan);
			break;
		case "4":
			System.out.println();
			break;
		case "5":
			cm.makeaPayment(scan);
			System.out.println();
			break;
		case "6":
			cm.addSubscriber(scan);
			System.out.println();
			break;
		case "7":
			fc.run();
			break;
		default:
			System.out.println("Invalid input.");
			}
		}
		
	}
	
	
	
	
}
