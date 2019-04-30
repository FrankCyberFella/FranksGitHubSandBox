package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker {	//cannot be instantiated by itself
								//it can only be a base class
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
	// define abstract method that will be overridden by subclasses
	// ie. If a subclass wants to inherit this class it must provide overrides abstract methods
	//****************************************************************************************
		
		public abstract double calculateWeeklyPay(int numHoursWorked); //abstract method only has a method signature

}
