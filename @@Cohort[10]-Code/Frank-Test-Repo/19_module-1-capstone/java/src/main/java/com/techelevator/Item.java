package com.techelevator;

public class Item {

	// VARIABLES OR DATA MEMBERS //Each item has a Name and Price
	String name;
	double price;
	String foodType;
	double totalItemSales = 0;

	// CONSTRUCTORS // method to create an instance of a class.

	public Item(String name, double price, String foodType) {
		this.name = name;
		this.foodType = foodType;
		this.price = price;
	}
	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getFoodType() {
		return foodType;
	}

	public double getTotalItemSales() {
		return totalItemSales;
	}

	public void setTotalItemSales(double totalItemSales) {
		this.totalItemSales += totalItemSales;
	}

	// VARIABLES OR DATA MEMBERS

}
