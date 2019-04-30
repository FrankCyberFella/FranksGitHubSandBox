package com.techelevator;

public abstract class Slots extends VendingMachineCLI {
	
	//**********************
	// variables for Slots
	//**********************
	private double price;
	private String slotNumber;
	
	//**********************
	// Constructor
	//**********************
	public Slots(String slotNumber, double price) {
		this.slotNumber = slotNumber;
		this.price = price;
	}
	
	//**********************
	// Getters and Setters
	//**********************
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the slotNumber
	 */
	public String getSlotNumber() {
		return slotNumber;
	}
	/**
	 * @param slotNumber the slotNumber to set
	 */
	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	
}
