package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!"); //call the super class (FarmAnimal) cotr with data needed
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}