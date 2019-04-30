package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker implements PaidEmployee {  // abstract class - cannot be instantiated by itself
														// can only be a base class
														// require methods of the PaidEmployee interface
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
	// ie. If the a subclass wants to inherit this class it must provide abstract methods
	//****************************************************************************************
	
//	public double calculateIncomeTax(double pay) {
//		return 0.0;
//	}
//	
//	public abstract double  calculateWeeklyPay(int numHoursWorked);

}
