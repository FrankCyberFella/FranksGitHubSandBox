package com.techelevator.farm;

public class Person {
	protected String firstName;
	protected String lastName;

	public String getDescription() {
		System.out.println("In Person");
		return firstName + " " + lastName;
	}
}



