package com.techelevator;

import java.util.Stack;

public class Slot {

	private String slotNumber;
	private double price;
	private Stack<Item> stackOfItems = new Stack<Item>();
//	private Item anItem;
	
	
	public Slot(String slotNumber, double price, Stack<Item> stackOfItems) {
		this.slotNumber = slotNumber;
		this.price = price;
		this.stackOfItems = stackOfItems;
	}


  public String getSlots(String slotNumber) {
	  return this.slotNumber;
  }
  
  public double getPrice() {
	  return this.price;
  }
 

	

	public void setPrice(double price) {
	this.price = price;
}


	/**
	 * @param slotNumber the slotNumber to set
	 */
	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	public String getSlotNumber() {
		return slotNumber;
	}
	
	
	public Stack<Item> getStackOfItems() {
		return stackOfItems;
	}


	@Override
	public String toString() {
		return slotNumber + " " + price + " " + stackOfItems;
	}
	
}
