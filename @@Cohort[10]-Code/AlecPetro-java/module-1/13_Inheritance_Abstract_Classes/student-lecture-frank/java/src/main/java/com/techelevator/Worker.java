package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker implements PaidEmployee { //abstract class - cannot be instantiated by itself
														// can only be a base class
														// requiring methods of the PaidEmployee interface
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
	// Define an abstract method which requires the subclass to override
	//	ie. If a subclass wants to inherit this class it must provide override abstract methods
	//****************************************************************************************
		
	//	public abstract double calculateWeeklyPay(int numHoursWorked);	// abstract method only has a method signature
			

}
