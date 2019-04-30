package com.techelevator;

public class Elevator {
	
private int currentFloor = 1;
private int numberOfFloors;
private boolean doorOpen;

public Elevator(int totalNumberOfFloors) {
	numberOfFloors = totalNumberOfFloors;
}

public void openDoor() {
	doorOpen = true;
}

public void closeDoor() {
	doorOpen = false;
}

public void goUp(int desiredFloor) {
	if(!doorOpen) {
		if(desiredFloor > currentFloor) {
		currentFloor = desiredFloor;
		}
		if(currentFloor > numberOfFloors) {
			currentFloor = numberOfFloors;
		}
	}
}

public void goDown(int desiredFloor) {
	if(!doorOpen) {
		if(desiredFloor < currentFloor) {
		currentFloor = desiredFloor;
		}
		if(currentFloor < 1) {
			currentFloor = 1;
		}
	}
	
}

/**
 * @return the currentFloor
 */
public int getCurrentFloor() {
	return currentFloor;
}
/**
 * @return the numberOfFloors
 */
public int getNumberOfFloors() {
	return numberOfFloors;
}
/**
 * @return the doorOpen
 */
public boolean isDoorOpen() {
	return doorOpen;
}


}
