package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!"); //call superclass ctor with data it needs
	}

	@Override
	public String getSound() {
		return "Hi, I'm a Cow, " + super.getSound(); //need to use superclass method because sound is private
	}
	
}