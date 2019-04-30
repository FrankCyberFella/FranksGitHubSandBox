package com.techelevator.company;

public class Company {
	
	private String name;
	private int numberOfEmployees;
	private	double revenue;
	private double expenses;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	public String getCompanySize() {
		String size = "Unknown";
		if(numberOfEmployees <= 50) {
			size = "small";
		} else if(numberOfEmployees > 50 && numberOfEmployees <= 250) {
			size = "medium";
		} else if (numberOfEmployees > 250) {
			size = "large";
		}
		return size;
	}
	
	public double getProfit() {
		double profit = revenue - expenses;
		return profit;
	}
	
}
