package com.techelevator;

public class BiWeeklyEmployee extends Worker {

	double biWeeklyPay;
	
	public BiWeeklyEmployee(String firstName, String lastName, double pay) {
		super(firstName, lastName);
		this.biWeeklyPay = pay;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateWeeklyPay(int numHoursWorked) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateIncomeTax(double pay) {
		// TODO Auto-generated method stub
		return 0;
	}

}
