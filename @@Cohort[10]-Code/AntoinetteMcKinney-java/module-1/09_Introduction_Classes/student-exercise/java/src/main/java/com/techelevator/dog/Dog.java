package com.techelevator.dog;

public class Dog {
 
 //VARIABLES OR DATA MEMBERS
	private boolean sleeping;
	
	
	 // public Dog() { //this is a default constructor. Not needed now bec the
	  //constructor is already here. 
	 
	 /*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */
	
	 public boolean isSleeping() {// The Getter for name variable
		return sleeping;           // graph only asked for getter.
	}
	
	// METHODSS
	public String makeSound(){
	
		if (sleeping){
			return "Zzzzz...";
		
		} else 
		
		{
			return "Woof!";
		}
	}

	public void sleep(){ //setSleep(String sleep)
		this.sleeping = true; //this is referencing the name varialbe in the class. set to true.
	}
	
	public void wakeUp() { //setsWakeUp(String wakeUp) 
		this.sleeping = false; //this is referencing the name varialbe in the class. set to false.
	}

	
}
