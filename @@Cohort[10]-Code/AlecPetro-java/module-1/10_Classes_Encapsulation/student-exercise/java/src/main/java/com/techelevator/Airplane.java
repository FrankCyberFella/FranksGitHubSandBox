package com.techelevator;

public class Airplane {

private String planeNumber;
private int	bookedFirstClassSeats; // assign as = 0;
private int availableFirstClassSeats; // exclude since derived
private int totalFirstClassSeats;
private int bookedCoachSeats; // assign as = 0;
private int availableCoachSeats;
private int totalCoachSeats;

public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
	this.planeNumber = planeNumber;
	this.totalFirstClassSeats = totalFirstClassSeats;
	this.totalCoachSeats = totalCoachSeats;
	getAvailableFirstClassSeats();
	determineCoachSeats(totalCoachSeats, bookedCoachSeats);
}



private void determineCoachSeats(int totalCoachSeats, int bookedCoachSeats) {
	availableCoachSeats = totalCoachSeats - bookedCoachSeats;
}

public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
	if(forFirstClass) {
		if(totalFirstClassSeats > totalNumberOfSeats) {
			availableFirstClassSeats = totalFirstClassSeats - totalNumberOfSeats;
			bookedFirstClassSeats = totalFirstClassSeats - availableFirstClassSeats;
		return true;
	}
	}
	else if(totalCoachSeats > totalNumberOfSeats) {
			availableCoachSeats = totalCoachSeats - totalNumberOfSeats;
			bookedCoachSeats = totalCoachSeats - availableCoachSeats;
		return true;
	}
	return false;
}

/**
 * @return the planeNumber
 */
public String getPlaneNumber() {
	return planeNumber;
}
/**
 * @return the bookedFirstClassSeats
 */
public int getBookedFirstClassSeats() {
	return bookedFirstClassSeats;
}
/**
 * @return the availableFirstClassSeats
 */
public int getAvailableFirstClassSeats() {
	return totalFirstClassSeats - bookedFirstClassSeats; // should be totalFirstClassSeats - bookedFirstClassSeats;
}
/**
 * @return the totalFirstClassSeats
 */
public int getTotalFirstClassSeats() {
	return totalFirstClassSeats;
}
/**
 * @return the bookedCoachSeats
 */
public int getBookedCoachSeats() {
	return bookedCoachSeats;
}
/**
 * @return the availableCoachSeats
 */
public int getAvailableCoachSeats() {
	return availableCoachSeats;
}
/**
 * @return the totalCoachSeats
 */
public int getTotalCoachSeats() {
	return totalCoachSeats;
}




	
}
