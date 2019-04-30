package com.techelevator;

public class VolunteerWorker extends Worker {
	
	public VolunteerWorker(String firstName, String lastName) {
		super(firstName, lastName);
		
	}
	
@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double volunteerPay = hoursWorked * 0;
		return volunteerPay;
		
	}
}
