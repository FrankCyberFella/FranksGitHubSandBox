package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!"); // called super class constructor with the data it needs
	}
@Override
public String getSound() {
	
	
	return "Hi I'm a Cow and I say " + super.getSound(); // use .getSound because sound is private in the super class. Need to use the superclass method. Want it to return and say
	}






}