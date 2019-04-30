package com.techelevator.dog;

public class Dog {

private boolean sleeping = false;
	//
	// Write code here
	//

/**
 * @return the sleeping
 */
public boolean isSleeping() {
	return sleeping;
}

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

}
