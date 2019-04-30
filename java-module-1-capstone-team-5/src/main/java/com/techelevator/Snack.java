package com.techelevator;


public class Snack {
	private double cost = 0;
	private String type = "";
	private String name ="";
	private String slot = "";
	

	public Snack(String slot, String name, double cost, String type) {
		this.slot = slot;
		this.type = type;
		this.name = name;
		this.cost = cost;
	}


	public String getType() {
		return type;
	}



	public String getName() {
		return name;
	}


	public double getCost() {
		return cost;
	}


	public String getSlot() {
		return slot;
	}
	
	public String toString() {
		return getName().toString();
	}

	

}
