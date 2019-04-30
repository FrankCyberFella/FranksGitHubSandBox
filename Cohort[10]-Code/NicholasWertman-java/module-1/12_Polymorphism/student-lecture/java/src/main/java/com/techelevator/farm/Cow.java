package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");		//call super class ctor with data it needs
	}
	
	@Override
	public String getSound() {
		
		return "Hi I'm a cow and I say " + super.getSound();// need to use the super class method because sound is private in the super class, aka we have no access to sound.
	
	}

}