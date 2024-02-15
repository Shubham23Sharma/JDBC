package com.jspider.secondassignment.controller;

import java.util.Scanner;

public class Employee {
	int pwd=2243;
	private int id;
	private String name;
	private String email;
	private long phone;
	private String dob;
	
	public Employee()
	{
		
	}
	
	
	public Employee(int id, String name, String email, long phone, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
			this.id = id;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	

}
