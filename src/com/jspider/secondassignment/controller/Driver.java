package com.jspider.secondassignment.controller;

import java.util.Scanner;

public class Driver {

	
		public static void main(String[] args) {
			Employee e=null;
			Scanner scn=new Scanner(System.in);
			while(true)
			{
			System.out.println("Press 1==> to Insert");
			System.out.println("Press 2 ==> to Update");
			System.out.println("Press 3 ==> to Delete");
			System.out.println("Press 4 ==> to Display Data");
			int choice=scn.nextInt();
			switch(choice)
			{
			case 1 : {
				System.out.println("Enter id");
				int id=scn.nextInt();
				System.out.println("Enter name");
				String name=scn.next();
				System.out.println("Enter email");
				String email=scn.next();
				System.out.println("Enter phone");
				long phone=scn.nextLong();
				System.out.println("Enter dob");
				String dob=scn.next();
				e=new Employee(id,name,email,phone,dob);
				break;
			}
			case 2 : {
				System.out.println("You have selected update data");
				System.out.println("Press 1 to update Name");
				System.out.println("Press 2 to update Email");
				System.out.println("Press 3 to update DOB");
				int choicee=scn.nextInt();
				switch(choicee)
				{
				case 1 :{
					System.out.println("Enter name");
					String name=scn.next();
					e.setName(name);
					break;
				}
				case 2 : {
					System.out.println("Enter email");
					String email=scn.next();
					e.setEmail(email);
					break;
				}
				case 3 : {
					System.out.println("Enter DOB");
					String dob=scn.next();
					e.setDob(dob);
					break;
				}
				default : System.err.println("Please enter a valid input");
				break;
				}
				break;
			}
			case 3 : {
				e.setId(0);
				e.setName(null);
				e.setEmail(null);
				e.setDob(null);
				e.setPhone(0);
				System.out.println("Data Deleted successfully!!!!");
				break;
			}
			case 4 : {
				System.out.println("ID is : "+e.getId());
				System.out.println("Name is : "+e.getName());
				System.out.println("Email is : "+e.getEmail());
				System.out.println("Phone is : "+e.getPhone());
				System.out.println("DOB is : "+e.getDob());
				break;
			}
			default : System.err.println("Please enter a valid input");
			break;
			}
			}
		}
}