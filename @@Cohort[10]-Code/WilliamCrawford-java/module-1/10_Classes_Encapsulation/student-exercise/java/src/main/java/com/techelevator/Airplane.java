package com.techelevator;

public class Airplane {
	
	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats  = 0;
	private int totalCoachSeats;
	
	private int bookedCoachSeats = 0;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		
	}
	
	
	
	
}
