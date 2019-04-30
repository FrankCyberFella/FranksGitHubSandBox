package com.techelevator.product;

public class Product // class
	{
	//VARIABLES OR DATA MEMBERS
		private String name; // These are what the object knows
		private double price;
		private double weightInOunces;
		

		// CONSTRUCTORS // method to create an instance of a class, thats why its
		// capatalized
		/*
		 * public The Product () { //this is a default constructor. Not needed now bec the
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

		public double getPrice() {// The Getter for name variable
			return price;
		}

		public void setPrice(int price) {// recieve
			this.price = price; // .this is referencing the name varialbe in the class.
		}

		public double getWeightInOunces() {// The Getter for name variable
			return weightInOunces;
		}

		public void setWeightInOunces(double weightInOunces) {// recieve
			this.weightInOunces = weightInOunces; // .this is referencing the name varialbe in the class.
		}

		
		// METHODSS there are no additional methods beyond the basic getters and setters.
		
}
