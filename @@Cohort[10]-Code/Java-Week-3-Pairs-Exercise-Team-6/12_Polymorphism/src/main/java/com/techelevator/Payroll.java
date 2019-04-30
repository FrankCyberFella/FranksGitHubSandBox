package com.techelevator;

import java.util.List;
import java.util.ArrayList;

public class Payroll {

	public static void main(String[] args) {
		List<Worker> payroll = new ArrayList<Worker>();
		
		Worker frankFella = new SalaryWorker("Frank", "Fella", 700000);
		Worker johnSmith = new HourlyWorker("John", "Smiths", 20.00);
		Worker bobRoss = new VolunteerWorker("Robert", "Ross");
		
		double totalPay = 0;
		double totalHours = 0;
		
		payroll.add(frankFella);
		payroll.add(johnSmith);
		payroll.add(bobRoss);
		
		System.out.println("Employee:      Hours:  Pay:");
		System.out.println(" ");
		
		for (Worker aWorker : payroll) {
			
			double randomHoursWorked = (Math.random() * 100);
			
			System.out.print(aWorker.getLastName() + ", " + aWorker.getFirstName() + "   ");
			System.out.printf("%.2f", randomHoursWorked);
			System.out.print("   ");
			System.out.printf("%.2f\n", aWorker.calculateWeeklyPay(randomHoursWorked));
			
			totalHours += randomHoursWorked;
			totalPay += aWorker.calculateWeeklyPay(randomHoursWorked);
			
		}
		System.out.println("-------------------");
		System.out.printf("Total Hours: %.2f\n", totalHours);
		System.out.printf("Total Pay: $%.2f\n", totalPay);
	}
}
