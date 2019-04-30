package com.techelevator;

public class HourlyWorker extends Worker {

	private double hourlyRate;

	HourlyWorker(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
	}
	
@Override
	public double calculateWeeklyPay(double hoursWorked) {
		double pay = hourlyRate * hoursWorked;
		
		if (hoursWorked > 40) {
			double overtime = hoursWorked - 40;
			pay = pay + (hourlyRate * overtime * 0.5);
			return pay;
		} else
			return pay;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

}
