package com.techelevator;

public class Worker {
	// data members --------------------
	private String firstName;
	private String lastName;
	
	//ctor -------------------------
	public Worker() {
		firstName="";
		lastName="";
	}
	
	public Worker (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//getters and setters -----------------
	
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

	//methods ----------------------------
	public double calculateWeeklyPay (int hoursWorked) {
		return 0.00;
	}
	
}
