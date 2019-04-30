package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");     //calls super class ctor with data it needs
	}
@Override
	public String getSound() {
	
	return "Hi I'm a Cow and I say " + super.getSound();     // need to use super class method because sound is private in superclass
	
	} 
	
}