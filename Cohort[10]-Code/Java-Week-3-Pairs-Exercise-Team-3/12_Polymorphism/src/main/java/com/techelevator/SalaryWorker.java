package com.techelevator;

public class SalaryWorker extends Worker { // made SalaryWorker child of Worker
	private double annualSalary;
	
	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		super(firstName, lastName);
		this.annualSalary = annualSalary;
		
	}
	
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double salaryPay = annualSalary / 52;
		return salaryPay;
	
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
}
