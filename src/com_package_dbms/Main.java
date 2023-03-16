package com_package_dbms;

import java.util.Scanner;
import com_package_dbms.Crud_Controllers;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("WELCOME TO STUDENT DATABASE MANAGEMENT SYSTEM");
		System.out.println("---------------------------------------------");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Please type any option to continue: ");
		System.out.println("---------------------------------------------");
		System.out.println("1. Get All Students' Details");
		System.out.println("2. Add Students Details");
		System.out.println("3. Get Student's Details by ID");
		System.out.println("4. Edit Student's Details");
		System.out.println("5. Edit Student's Details");
		System.out.print("Enter here: ");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice){
			case 1: Crud_Controllers.readDetails();
					break;
			
			case 2: System.out.println("Enter Student Name: ");
					String name = input.nextLine();
					
					System.out.println("Enter Student USN: ");
					String roll = input.nextLine();
					
					System.out.println("Enter Student Department: ");
					String dept = input.nextLine();
						
					Crud_Controllers.saveDetails(name, roll, dept);
					break;
					
			case 3: System.out.println("Please enter the student id: ");
					int id = input.nextInt();
					Crud_Controllers.readDataById(id);
					break;
			
			case 4: System.out.print("Please enter the student id: ");
			        int e_id = input.nextInt();
			        
			        System.out.print("Please enter the student name: ");
			        String e_name = input.nextLine();
			        
			        System.out.print("Please enter the student USN: ");
			        String e_roll = input.nextLine();
			        
			        System.out.print("Please enter the student Department: ");
			        String e_dept = input.nextLine();
			        
			        String newData= e_name + " " +  e_roll + " " + e_dept;
			        
			        Crud_Controllers.editDataById(e_id, newData);
			        break;
			        
			case 5: System.out.print("Please enter the student id: ");
					int d_id = input.nextInt();
					Crud_Controllers.deleteDataById(d_id);
					break;
		}
		input.close();
	}

}
