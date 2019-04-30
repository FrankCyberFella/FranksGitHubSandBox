package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");
	}
	@Override
	public String getSound() {
		return "Hi I'm a cow and I say " + super.getSound();//have to use getSound because sound is a private variable
	}

}