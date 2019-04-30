package com.techelevator.dog;

public class Dog {
private boolean sleeping = false;

public String makeSound() {
	if (sleeping == true) {
		return "Zzzzz...";
	}
	
			return "Woof!";
}
	

public void sleep() {
	this.sleeping = true;
}

public boolean isSleeping() {
	return sleeping;
}


public void wakeUp() {
	this.sleeping = false;
}



}




