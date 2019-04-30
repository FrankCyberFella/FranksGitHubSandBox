package com.techelevator;

public class HourlyWorker extends Worker {
	
	private double hourlyRate;
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay;
		
		pay = hourlyRate * hoursWorked;
		double overtime = hoursWorked - 40;
		pay = pay + (hourlyRate * overtime * .5);
		return pay;
		
	}
	
}
