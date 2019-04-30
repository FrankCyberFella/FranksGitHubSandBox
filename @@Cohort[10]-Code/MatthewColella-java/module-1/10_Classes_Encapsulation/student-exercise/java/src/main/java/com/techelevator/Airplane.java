package com.techelevator;

public class Airplane {

private String planeNumber;
private int bookedFirstClassSeats;
private int availableFirstClassSeats;
private int totalFirstClassSeats;
private int bookedCoachSeats;
private int availableCoachSeats;
private int totalCoachSeats;

public  Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
	this.totalFirstClassSeats = totalFirstClassSeats;
	this.totalCoachSeats = totalCoachSeats;
	availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
	availableCoachSeats = totalCoachSeats - bookedCoachSeats;
	this.planeNumber = planeNumber;
}

public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
	if(forFirstClass == true && totalNumberOfSeats <= availableFirstClassSeats) {
		bookedFirstClassSeats += totalNumberOfSeats; 
		availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		return true;
	}
	if(forFirstClass == false && totalNumberOfSeats <= availableCoachSeats) {
		bookedCoachSeats += totalNumberOfSeats; 
		availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		return true;
	}
	
	
	return false;
}


public String getPlaneNumber() {
	return planeNumber;
}

public int getBookedFirstClassSeats() {
	return bookedFirstClassSeats;
}

public int getAvailableFirstClassSeats() {
	return availableFirstClassSeats;
}

public int getTotalFirstClassSeats() {
	return totalFirstClassSeats;
}

public int getBookedCoachSeats() {
	return bookedCoachSeats;
}

public int getAvailableCoachSeats() {
	return availableCoachSeats;
}

public int getTotalCoachSeats() {
	return totalCoachSeats;
}
	
}
