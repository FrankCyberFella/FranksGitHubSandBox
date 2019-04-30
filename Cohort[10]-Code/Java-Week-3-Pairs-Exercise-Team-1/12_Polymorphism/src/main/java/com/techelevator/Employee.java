package com.techelevator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
	public static void main(String[] args) {


	Worker          jake  = new HourlyWorker("Jake", "Searle", 50.00);
	SalaryWorker    tom   = new SalaryWorker("Tom", "Richards", 50000.00);
	VolunteerWorker tyler = new VolunteerWorker("Tyler", "Klinger");
	
	int hoursWorked = 50;
	
	Worker[] employees = new Worker[] {jake, tom, tyler};
	
	
	for(Worker employeeList : employees) {
		System.out.println(employeeList.getFirstName() + " " + employeeList.getLastName() + " " + employeeList.calculateWeeklyPay(hoursWorked));
	}
	
	
	
	
	}
	
	
}