package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker implements PaidEmployees{
	//requiring methods of paid employee interface
	//****************************************************************************************
	// Data members / Instance Data
	//****************************************************************************************
		
	String firstName;
	String lastName;
	
	//****************************************************************************************
	// member functions
	//****************************************************************************************

	public Worker(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName  = lastName;
	}
	
	//****************************************************************************************
	// Getters / Setters
	//****************************************************************************************
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	//****************************************************************************************
	// Need to define "dummy" method that will be overridden by subclasses
	//****************************************************************************************
		
	//Defining an abstract method which requires the subclass to override it
	
		//public abstract double calculateWeeklyPay(int numHoursWorked);
		// WIth the interface implemented in the base class, you dont need the weekly pay in here because its already in the interface
}
