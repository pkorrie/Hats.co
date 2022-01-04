package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.HatAlreadyExistsException;
import com.revature.models.Hat;
import com.revature.services.HatService;

public class HatController {
	
	HatService hs = new HatService();
	
	public void addNewHat(Scanner scan) {
		System.out.println("Enter a Type: ");
		String type = scan.nextLine();
		System.out.println("Enter a Price: ");
		int price = Integer.parseInt(scan.nextLine());
		System.out.println("Enter Color: ");
		String color = scan.nextLine();
		System.out.println("Enter Size: ");
		String size = scan.nextLine();
		
		Hat newHat = new Hat(0,type,price,color,size,null);
		
		try {
			newHat = hs.addHat(newHat);
			System.out.println( newHat.getType() + "has been add!");
		} catch (HatAlreadyExistsException h) {
			System.out.println("Username is already in use.Please try again.");
		}
	}
}
