package com.techelevator;

public class Employee {
//Class Data Members----------------------------
	private int employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
//CTOR ------------------------------------
	public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
	this.employeeId = employeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.annualSalary = annualSalary;
	fullName = lastName + ", " + firstName;
//Getters and Setters ----------------------------
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getFullName() {
		return fullName;
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	//Return ---------------------------------------
	public void raiseSalary (double percent) {
		double percentDecimal = percent / 100;
		annualSalary = annualSalary * (1 + percentDecimal);
	}
	
}
