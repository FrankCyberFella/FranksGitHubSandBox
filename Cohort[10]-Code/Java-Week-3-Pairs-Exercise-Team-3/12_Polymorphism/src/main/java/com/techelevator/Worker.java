package com.techelevator;

import java.util.ArrayList;


public class Worker {

	//VARIABLES OR DATA MEMBERS
	private String firstName;
	private String lastName;
	
	//CONSTRUCTORS // method to create an instance of a class,
	public Worker(String firstName, String lastName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}


	//Getters & Setters

	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	// Methods
	public double calculateWeeklyPay(int hoursWorked) {
		return (double)hoursWorked;

	
			
		}
		
}
