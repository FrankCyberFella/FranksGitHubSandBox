package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WorkerProgram {

	public static void main(String[] args) {
		Worker Sam = new HourlyWorker("Sam", "Petitti", 350.00);
		Worker Cyrus = new SalaryWorker("Cyrus", "Fiete", 75000.00);
		Worker Frank = new VolunteerWorker("Frank", "Fella");
		
		List <Worker> payroll = new ArrayList <Worker>();	
		payroll.add(Sam);
		payroll.add(Cyrus);
		payroll.add(Frank);
		
		int totalHours = 0;
		BigDecimal totalPay = new BigDecimal(0.0);
		
		for(Worker employee : payroll) {
			int hours = (int)(Math.random()*100);
			BigDecimal pay = new BigDecimal(employee.calculateWeeklyPay(hours));
			System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName() + "\nHours: " + hours + "\nPay: " + pay.setScale(2, RoundingMode.UP) + "\n");
			totalHours += hours;
			totalPay.add(pay);
		}
		
		System.out.println("Total Hours: " + totalHours);
		System.out.println("Total Pay: " + totalPay.setScale(2, RoundingMode.UP));
	
	}
}
