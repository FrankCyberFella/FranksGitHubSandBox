package com.techelevator;

public class BiWeeklyEmployee extends Worker {

	public BiWeeklyEmployee(String fname, String lname) {
		super(fname, lname);
	}
	
	@Override
	public double calculateWeeklyPay(int numHoursWorked) {
		return 0;
	}
	
	@Override
	public double calculateIncomeTax(double pay) {
		return 0;
	}
}
