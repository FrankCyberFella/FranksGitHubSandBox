package com.techelevator;

public abstract class Items extends Slots {

	private int inventory;
	private String name;
	private int numberBought = 0;
	
	
	/**
	 * @param numberBought the numberBought to set
	 */
	//**********************************
	// Getters and Setters
	//**********************************
	public void setNumberBought() {
		this.numberBought += 1;
	}
	public void resetNumberBought() {
		this.numberBought = 0;
	}
	public int getNumberBought() {
		return numberBought;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the inventory
	 */
	public int getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory() {
		this.inventory -=  1;
	}
	//**********************************
	// Main Constructor
	//**********************************
	public Items(String slotNumber,String name, double price) {
	super(slotNumber, price);
	this.inventory = 5; //Change Later
	this.name = name;
	
	}
	//**********************************
	// Methods
	//**********************************
	public void Consumed() {
		
	}


	
	
}
