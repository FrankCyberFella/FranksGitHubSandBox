package com.techelevator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Item {
	
	private String name;
	private String price;
	private String type;
	private String slotNum;
	private int quantity;
	NumberFormat decimalPlaces;
	
	public Item() {
		
	}
	
	

	public Item(String slotNum, String name, String price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.slotNum = slotNum;
		this.quantity = quantity;
		decimalPlaces = new DecimalFormat("#0.00");
	}

	
	public String getSlotNum() {
		return slotNum;
	}
	
	
	public int getQuantity() {   //pretty sure this does nothing. can be refactored out after testing
		
		return quantity ;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		double priceItem = Double.parseDouble(price);
		return priceItem;
	}
	
	public void getSound() {
		if(type.equalsIgnoreCase("Chip")) {
			System.out.println("Crunch, Crunch, Yum!");
		}
		if(type.equalsIgnoreCase("Drink")) {
			System.out.println("Glug, Glug, Yum!");
		}	
		if(type.equalsIgnoreCase("Gum")) {
			System.out.println("Chew, Chew, Yum!");
		}
		if(type.equalsIgnoreCase("Candy")) {
			System.out.println("Munch,  Munch, Yum!");
		}
	}
	
	public String getSlotId() {
		return slotNum;
	}
	
	
	public String toString() {
	
		return(name + " - $" + price);
	}
	
	public String toLogString() {
		return (name + ": " +slotNum);
	}
	
	
}
