package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class TestWorker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Worker Antoinette = new SalaryWorker("Antoinette", "McKinney", 500.00);
		Worker Serene = new HourlyWorker("Serene", "Luta", 50.00);
		Worker Joe = new VolunteerWorker("Joe", "Schmo");
		
		List<Worker> payroll = new ArrayList <Worker>();

		payroll.add(Antoinette);
		payroll.add(Serene);
		payroll.add(Joe);
		
		int hoursWorked = 0;
		double pay = 0.0;
		
			for(Worker employee: payroll ) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " gets paid " + employee.calculateWeeklyPay(40));
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " gets paid " + employee.calculateWeeklyPay(50));

				
			}
		}
	}

