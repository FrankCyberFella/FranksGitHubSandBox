package com.techelevator;

public class Airplane {
	
public String planeNumber; 
public int bookedFirstClassSeats = 0;
public int totalFirstClassSeats;
public int bookedCoachSeats = 0;
public int totalCoachSeats; 

public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
	this.planeNumber = planeNumber;
	this.totalFirstClassSeats = totalFirstClassSeats;
	this.totalCoachSeats = totalCoachSeats;
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
	return totalFirstClassSeats - bookedFirstClassSeats;
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
	return totalCoachSeats - bookedCoachSeats;
}
/**
 * @return the totalCoachSeats
 */
public int getTotalCoachSeats() {
	return totalCoachSeats; 
}

public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) { 
	if (forFirstClass) { 
		if (totalNumberOfSeats > getAvailableFirstClassSeats()) {
			return false;
		}
		bookedFirstClassSeats += totalNumberOfSeats;
	} 
	
	else {
		if (totalNumberOfSeats > getAvailableCoachSeats()) {
			return false;
		}
		bookedCoachSeats += totalNumberOfSeats;
}
		return true; 
}



}
