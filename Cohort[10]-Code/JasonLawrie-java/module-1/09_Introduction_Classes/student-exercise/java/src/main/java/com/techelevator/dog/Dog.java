package com.techelevator.dog;

public class Dog {

	/**
	 * @return the sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}
	//
	// Write code here
	//
	private boolean sleeping=false;
	
	public String makeSound() {
		String sound="";
		if (sleeping){
			sound="Zzzzz...";
		} else {
			sound="Woof!";
		}
		return sound;
	}
	public void sleep() {
		sleeping=true;
	}
	public void wakeUp() {
		sleeping=false;
	}
}
