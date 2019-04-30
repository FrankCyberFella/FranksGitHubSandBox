package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public abstract class Worker implements PaidEmployees{   // making this abstract during lecture
	// added interface -- now require methods of the Paid Employees interface.

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
		// lecture >>>>   change to abstract method, which will require the subclass to override
	// i.e If a sublcass wants to inherit htis class it must provide the abstract methods.
		
	//public abstract double calculateWeeklyPay(int numHoursWorked);
	
	//method body removed when we changed method to abstract.
}