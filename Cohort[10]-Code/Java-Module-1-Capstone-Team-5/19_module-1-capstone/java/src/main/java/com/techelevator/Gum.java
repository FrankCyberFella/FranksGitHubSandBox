package com.techelevator;

public class Gum extends Items {
	//private String name;
	@Override
public void Consumed() {
		System.out.println("Chomp, Smack, Pop!");
	}
	
	public Gum(String slotNumber, String name, double price) {
		super(slotNumber, name,price);
		//this.name = name;
	}
	@Override
	public String toString() {
		return super.getName();
}
}
