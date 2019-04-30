package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker {// abstract class - it cannot be instantiated by itself
							// can only be a base class
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
	// Define an abstract method whic requires the subclass to override
	// ie. if a subclass wants to inherits this class it must provide abstract methods
	//****************************************************************************************
		
		public abstract  double calculateWeeklyPay(int numHoursWorked) { //abstract method only has a method signiture
			return -1;
		}

}
