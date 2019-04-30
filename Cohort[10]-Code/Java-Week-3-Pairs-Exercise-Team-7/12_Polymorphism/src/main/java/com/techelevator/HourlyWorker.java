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
		double overtime = hoursWorked - 40;
		double pay = hourlyRate * hoursWorked;
		if(overtime > 0) {
			pay = pay + (overtime*.5*hourlyRate);
			return pay;
		}
		return pay;
	}
	

}
