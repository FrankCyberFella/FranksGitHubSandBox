package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");
	}
	
	
	public String getSound() {
		
		return "Hi I'm a Cow and I say moo" + super.getSound();  // need to use  *** super class method because sound is private in super class
		
	}

}