package com.techelevator.dog;

public class Dog {

	
	private boolean sleeping = false;

	/**
	 * @return the sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}

	/**
	 * @param sleeping the sleeping to set
	 */
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
	
	public String makeSound() {
		if (!sleeping) {
			return "Woof!";
		} 
			return "Zzzzz...";
		
		
	}
	
	public void sleep() {
		sleeping = true;
	}
	
	public void wakeUp() {
	
		sleeping = false;
		
	}
	

	// Write code here
	//
	
}
