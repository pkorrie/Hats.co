package com.revature.controllers;



import java.util.Scanner;



public class FrontController {
	
	private Scanner sc;
	private EntryController ec;

	public FrontController() {
		sc = new Scanner(System.in);
		ec = new EntryController();
		
	}
	
	public void run()  {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome to KoHats! What would you like to do:");
			System.out.println("1, Register");
			System.out.println("2, Login");
			System.out.println("3, Exit");
			
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
					ec.register(sc);
				System.out.println();
				break;
			case "2":
				ec.Login(sc);
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		sc.close();
	}

}
