package com.techelevator;

public class VolunteerWorker extends Worker{

	VolunteerWorker(String firstName, String lastName){
		super(firstName, lastName);
	}
	
	@Override
	public double calculateWeeklyPay(double hoursWorked){
		double pay = hoursWorked * 0;
		return pay;
	}
}
