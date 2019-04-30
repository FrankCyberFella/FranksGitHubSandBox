package com.techelevator.farm;

public class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!"); //calling the superClass ctor for the data it needs.
	}
	
	@Override
	public String getSound() {
		return "I say I say I say " + super.getSound(); //need to use the superclass method because sound is private in superclass
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}