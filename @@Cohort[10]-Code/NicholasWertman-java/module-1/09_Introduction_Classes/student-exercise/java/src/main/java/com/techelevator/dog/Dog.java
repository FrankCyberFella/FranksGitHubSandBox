package com.techelevator.dog;

public class Dog {

	private boolean sleeping;

	
	public void sleep() {
		this.sleeping = true;
	}
	
	public void wakeUp() {
		this.sleeping = false;
	}
	/**
	 * @return the sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}
	
	public String makeSound() {
		if (sleeping==true) {
			
		
			return "Zzzzz...";
		}
		
		return "Woof!";
		
		}
	

//
// Write code here
//

}
