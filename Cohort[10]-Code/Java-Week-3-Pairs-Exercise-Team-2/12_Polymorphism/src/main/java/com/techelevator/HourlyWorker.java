package com.techelevator;

public class HourlyWorker extends Worker {
	// data members ---------------------
	
	private double hourlyRate;
	
	// ctor -----------------------------
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
	}
	// getters and setters --------------
	public double getHourlyRate() {
		return hourlyRate;
	}
	// methods --------------------------
	
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = hourlyRate * hoursWorked;
		double overtime = hoursWorked - 40;
		if (overtime > 0) {
			pay = pay + (hourlyRate * overtime * .5);
		}
		return pay;
	}
}
