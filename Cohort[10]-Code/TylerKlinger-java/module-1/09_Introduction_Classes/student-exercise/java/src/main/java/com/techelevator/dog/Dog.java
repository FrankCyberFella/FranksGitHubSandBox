package com.techelevator.dog;

public class Dog {

	//when creating class, set up boolean sleeping = false;
	// Write code here
	//
	public boolean sleeping = false; 
	
	public String makeSound() {
		if (sleeping == true) {
			return "Zzzzz...";
		}
		else {
			return "Woof!";
		}
	}
	public void sleep() {
		sleeping = true;
	}
	public void wakeUp() {
		sleeping = false;
	}
	public boolean isSleeping() {
		return sleeping;
	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
}
