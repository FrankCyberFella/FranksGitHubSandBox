package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!");          // calls the super class constructor with the data it needs
	}
	 
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}