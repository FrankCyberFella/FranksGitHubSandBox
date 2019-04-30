package com.techelevator;

public class HourlyWorker extends Worker {
	
	private double hourlyRate;
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
	}
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		 double pay = hoursWorked * this.hourlyRate;
		 double overtime = hoursWorked - 40;
		 if(hoursWorked <= 40) {
			 return pay;
		 }
		 if(hoursWorked > 40) {
			 pay = pay + (this.hourlyRate * overtime *.5);
			 return pay;
		 }
		return pay;
		
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	
}
