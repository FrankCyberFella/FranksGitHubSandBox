package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!"); // calls the superclass constructor
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}