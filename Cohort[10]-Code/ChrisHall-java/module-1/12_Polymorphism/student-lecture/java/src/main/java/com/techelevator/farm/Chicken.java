package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!"); // super calls the super class (FarmAnimal) constructor with the data it needs
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}