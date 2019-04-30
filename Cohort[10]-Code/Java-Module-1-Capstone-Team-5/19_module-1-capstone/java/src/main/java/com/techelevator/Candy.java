package com.techelevator;

public class Candy extends Items {
	//private String name;
	@Override
public void Consumed() {
		System.out.println("Munch, Munch, Yum!");
	}
	public Candy(String slotNumber, String name, double price) {
		super(slotNumber,name, price);
		//this.name = name;
	}
	@Override
	public String toString() {
		return super.getName();
}
}
