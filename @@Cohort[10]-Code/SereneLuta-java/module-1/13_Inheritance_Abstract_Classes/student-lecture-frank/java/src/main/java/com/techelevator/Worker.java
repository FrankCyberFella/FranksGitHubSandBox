package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker implements PaidEmployees { // an abstract class = cannot be instantiated by itself
							   // it can only be a base class
							   // "implements" states you must use the methods required by the interface
							   // Worker's sub classes will inherit the interface
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
		
	public abstract double calculateWeeklyPay(int numHoursWorked); // abstract method defined
	// define an abstract method which requires the subclass to override
	// ex: If a subclass wants to inherit this class it must provide overrides for abstract methods in base class
	// must initiate an @Override to use the method

//	
//		public double calculateWeeklyPay(int numHoursWorked) { //dummy method 
//			return -1; // make it return a value that you know shouldn't be returned
//		} 			   // by your other methods in your sub classes

}
