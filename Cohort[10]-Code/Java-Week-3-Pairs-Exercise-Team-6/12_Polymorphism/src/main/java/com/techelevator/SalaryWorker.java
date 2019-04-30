package com.techelevator;

public class SalaryWorker extends Worker {

	private double annualSalary;
	
	SalaryWorker(String firstName, String lastName, double annualSalary){
		super(firstName, lastName);
		this.annualSalary = annualSalary;
		
	}
	
	@Override
	public double calculateWeeklyPay(double hoursWorked){
		double pay = annualSalary / 52;
		return pay;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}
	
}
