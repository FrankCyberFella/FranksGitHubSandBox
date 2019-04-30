package com.techelevator2;

public class SoftTaco extends Taco {

	public SoftTaco(int quantity, int price) {
		super(quantity,price);
	}
	
	@Override
	public String toString() {
		return "You have ordered " + super.getQuantity() + " soft tacos. Your total price is: $" + super.getPrice();
	}
	
}
