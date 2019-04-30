package com.techelevator.shoppingcart;

public class ShoppingCart // class
{
//VARIABLES OR DATA MEMBERS
	private double totalNumberOfItems;// These are what the object knows
	private double totalAmountOwed;

	// CONSTRUCTORS // method to create an instance of a class, thats why its
	// capatalized
	/*
	 * public ShoppingCart() { //this is a default constructor. Not needed now bec the
	 * constructor is already in the {
	 */

	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */

	public double getTotalNumberOfItems() {// The Getter for name variable
		return totalNumberOfItems;
	}

	public void setTotalNumberOfItems(double totalNumberOfItems) {// recieve
		this.totalNumberOfItems = totalNumberOfItems ; // .this is referencing the name varialbe in the class.
	}

	public double getTotalAmountOwed() {// The Getter for name variable
		return totalAmountOwed;
	}

	public void setTotalAmountOwed(double totalAmountOwed) {// recieve
		this.totalAmountOwed = totalAmountOwed; // .this is referencing the name varialbe in the class.
	}

	
	// METHODSS
	 public double getAveragePricePerItem() {
		 return (totalAmountOwed / totalNumberOfItems);
	 }
	 
	 public void addItems(double numberOfItems, double pricePerItem) {
		 totalNumberOfItems += numberOfItems; // this adds the number of items 
		 totalAmountOwed += (pricePerItem * numberOfItems);//adds to the total amout to the cart thats already there.
	 }
	 
	 public void empty() {
		 totalNumberOfItems = 0.0; // resets to 0
		 totalAmountOwed = 0.0; // resets to 0
	 }
}