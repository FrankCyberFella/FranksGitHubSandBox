package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!"); // call the super class constructor with the data it needs
	}
	
	@Override
	public String getSound() {
		return "I say, I say " + super.getSound();
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}