package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!"); //call the super class (FarmAnimal) cotr with data needed
	}
@Override
	public String getSound() {
	
	
	
	return "Hi I'm a Cow and I say " + super.getSound();  // need to use the super class method because sound is private in super class	
	
	}
}