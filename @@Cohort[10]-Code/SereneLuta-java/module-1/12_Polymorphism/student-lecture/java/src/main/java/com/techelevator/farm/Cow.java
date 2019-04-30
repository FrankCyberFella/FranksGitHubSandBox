package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!"); // call the super class constructor with the data it needs
	}

	@Override
	public String getSound() {
		return "Hi, I'm a Cow and I say " + super.getSound(); // need to use the super class method b/c sound is private in super class
	}
}