package com.techelevator.person;

public class Person {

	// VARIABLES OR DATA MEMBERS
	private String firstName; // These are what the object knows
	private String lastName;
	private int age; //The age of the person.

	// CONSTRUCTORS // method to create an instance of a class, thats why its
	// capatalized
	/*
	 * public Person() { //this is a default constructor. Not needed now bec the
	 * constructor is already in the {
	 */

	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */

	public String getFirstName() {// The Getter for name variable
		return firstName;
	}

	public void setFirstName(String firstName) {// recieve
		this.firstName = firstName; // .this is referencing the name varialbe in the class.
	}

	public String getLastName() {// The Getter for name variable
		return lastName;
	}

	public void setLastName(String lastName) {// recieve
		this.lastName = lastName; // .this is referencing the name varialbe in the class.
	}

	public int getAge() {// The Getter for name variable
		return age;
	}

	public void setAge(int age) {// recieve
		this.age = age; // .this is referencing the name varialbe in the class.
	}

	// METHODSS
	public String getFullName() {// Method
		return lastName + ", " + firstName;
	}

	public boolean isAdult() {
		if (age >= 18) {
			return true;
		} else {
			return false;
		}
	}
}
