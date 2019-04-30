package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("chicken", "cluck!"); //call the superclass ctor with the data it needs
	}
	
	public String getSound() {
		return "I say, I say " + super.getSound();
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}