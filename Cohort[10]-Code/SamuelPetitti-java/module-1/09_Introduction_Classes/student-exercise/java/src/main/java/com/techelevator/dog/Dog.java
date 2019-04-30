package com.techelevator.dog;

public class Dog {

	private boolean sleeping = false;
	
	/**
	 * @return the sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}

	public String makeSound() {
		if(sleeping) {
			return "Zzzzz...";
		} return  "Woof!";
	}
	
	public void sleep() {
		this.sleeping = true;
	}
	
	public void wakeUp() {
		this.sleeping = false;
	}
	
	//
	// Write code here
	//
	
}
