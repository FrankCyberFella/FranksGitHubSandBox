package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationTest {
	public static void main(String[] args) {

		List<Worker> employees = new ArrayList<Worker>();

		Worker salaryWorkerOne = new SalaryWorker("Joe", "Smith", 40000.00);
		Worker hourlyWorkerOne = new HourlyWorker("Ted", "Williams", 12.00);
		Worker volunteerWorkerOne = new VolunteerWorker("Bob", "Jones");

		employees.add(salaryWorkerOne);
		employees.add(hourlyWorkerOne);
		employees.add(volunteerWorkerOne);
		
		double result = 0.00;
		System.out.println("Employee" + "\t" + "Hours Worked" + "\t" + "Pay");
		
		for (Worker employee : employees) {

//			System.out.println("Test using 50 hours: " + employee.getFirstName() + " " + employee.calculateWeeklyPay(50));
//			System.out.println("Test using 40 hours: " + employee.getFirstName() + " " + employee.calculateWeeklyPay(40));
//			System.out.println("Test using 30 hours: " + employee.getFirstName() + " " + employee.calculateWeeklyPay(30));
//			

			System.out.println(employee.getLastName() + "," + employee.getFirstName() + "\t" + 50 + "\t" + "\t"
					+ employee.calculateWeeklyPay((50)));

			result += employee.calculateWeeklyPay(50);

		}
		System.out.println("Total Pay: " + result);
	}
}
