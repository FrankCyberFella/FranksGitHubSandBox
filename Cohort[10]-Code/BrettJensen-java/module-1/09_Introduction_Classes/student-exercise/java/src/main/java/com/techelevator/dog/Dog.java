package com.techelevator.dog;

public class Dog {

	private boolean sleeping = false;
	
	public String makeSound() {
		if(sleeping) {
			return "Zzzzz...";
		} else {
			return "Woof!";
		}
	}
	
	public boolean isSleeping() {
		return sleeping;
	}
	
	public void sleep() {
		sleeping = true;
	}
	
	public void wakeUp() {
		sleeping = false;
	}
	
}
