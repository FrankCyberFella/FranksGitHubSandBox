package com.techelevator;

//****************************************************************************************
// Generic Worker class to be used as a base class for all type of workers
//****************************************************************************************

public class Worker implements PaidEmployee { //abstract class -- cannot be instantiated by itself
					 //which means can only be a base class
					//requires methods of the PaidEmployee Interface
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
	
	//the abstract methods requires subclasses to override
	//ie. If a subclass wants to inherit this class it must provide abstract methods
	//****************************************************************************************
		
		//public double calculateWeeklyPay(int numHoursWorked) {
			//return -1;
			//for abstract: public abstract double calculateWeeklyPay(int numHoursWorked);
			//abstract methods only have the method signature
		}


