package com.techelevator;

public class Elevator {

	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen = false;
	
	
	public Elevator(int totalNumberOfFloors) {
		this.currentFloor = currentFloor;
		this.doorOpen = doorOpen;
		this.numberOfFloors = totalNumberOfFloors;
	}
	
	public void openDoor() {
		doorOpen = true;
		
	}
	
	public void closeDoor( ) {
		doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if (currentFloor currentFloor++;
	}
	
	public void goDown(int desiredFloor) {
		currentFloor--;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	
}

	