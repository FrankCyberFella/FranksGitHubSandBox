package com.techelevator;

public class VolunteerWorker extends Worker {
	
	public VolunteerWorker(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = hoursWorked * 0;
		return pay;
	}

}
