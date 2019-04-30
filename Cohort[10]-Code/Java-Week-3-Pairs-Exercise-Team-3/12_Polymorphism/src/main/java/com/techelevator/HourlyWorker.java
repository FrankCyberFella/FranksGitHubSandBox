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
		double overtimeHours = hoursWorked - 40;
		if(overtimeHours <= 0) {
		double pay = hourlyRate * hoursWorked;
		return pay;
		}
		else {
		if (overtimeHours > 0) {
		double overtimePay = (hourlyRate * overtimeHours * 1.5) + (hourlyRate * (hoursWorked - overtimeHours));
		return overtimePay;
		}
		return 0.0;
	
		}
	}
}

