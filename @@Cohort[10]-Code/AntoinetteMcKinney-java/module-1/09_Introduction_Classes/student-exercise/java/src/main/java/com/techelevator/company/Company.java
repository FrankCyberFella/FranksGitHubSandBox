//PACKAGES & IMPORTS
package com.techelevator.company;

public class Company // class
{
//VARIABLES OR DATA MEMBERS
	private String name; // These are what the object knows
	private int numberOfEmployees;
	private double revenue;
	private double expenses;

	// CONSTRUCTORS // method to create an instance of a class, thats why its
	// capatalized
	/*
	 * public Company() { //this is a default constructor. Not needed now bec the
	 * constructor is already in the {
	 */

	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */

	public String getName() {// The Getter for name variable
		return name;
	}

	public void setName(String name) {// recieve
		this.name = name; // .this is referencing the name varialbe in the class.
	}

	public int getNumberOfEmployees() {// The Getter for name variable
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {// recieve
		this.numberOfEmployees = numberOfEmployees; // .this is referencing the name varialbe in the class.
	}

	public double getRevenue() {// The Getter for name variable
		return revenue;
	}

	public void setRevenue(double revenue) {// recieve
		this.revenue = revenue; // .this is referencing the name varialbe in the class.
	}

	public Double expense() {// The Getter for name variable
		return expenses;
	}

	public void setExpense(double expense) {// recieve
		this.expenses = expense; // .this is referencing the name varialbe in the class.
	}

	// METHODSS
	public String getCompanySize() {// Method
		if (numberOfEmployees <= 50) {
			return "small";
		} else if ((numberOfEmployees >= 51) && (numberOfEmployees <= 250)) {
			return "medium";
		} else { 
			return "large";
			}
		}
	

	public double getProfit() {
		return revenue - expenses;
	}


	}

