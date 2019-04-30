package com.techelevator;

public class Drink extends Items {
	//private String name;
	@Override	
public void Consumed() {
		System.out.println("Slurp, Slurp ahhhh!");
	}
	public Drink(String slotNumber, String name, double price) {
		super(slotNumber,name, price);
		//this.name = name;
	}
	@Override
	public String toString() {
		return super.getName();
}
	
}
