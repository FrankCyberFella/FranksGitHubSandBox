package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("cow", "moo!");
	}
@Override	
	public String getSound() {
	return "Hi I'm a cow and I say " + super.getSound();
}

}