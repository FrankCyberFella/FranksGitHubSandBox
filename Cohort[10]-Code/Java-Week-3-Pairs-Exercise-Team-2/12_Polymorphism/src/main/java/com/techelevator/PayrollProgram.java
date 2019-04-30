package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PayrollProgram {
	public static void main(String[] args) {
		
	    int totalHoursWorked = 0;
		double totalPay =0.0;
		int hoursWorked = 80;
		Random rand = new Random();
		
		List<Worker> payroll = new ArrayList<Worker>();
		payroll.add(new SalaryWorker("Mickey","Mouse",120000));
		payroll.add(new VolunteerWorker("George (Goofy)","Geef"));
		payroll.add(new HourlyWorker("Daisy","Duck",13));
		payroll.add(new SalaryWorker("Minnie","Mouse",100000));
		
		System.out.printf("%24s \t %10s \t\t %10s \n", "Employee","Hours Worked","Weekly Pay");
		
		for(Worker employee:payroll) {
			hoursWorked=rand.nextInt(40)+40;
			totalHoursWorked += hoursWorked;
			totalPay += employee.calculateWeeklyPay(hoursWorked);
			//System.out.println(employee.getLastName()+", "+employee.getFirstName()+"\t\t"+hoursWorked+"\t\t"+employee.calculateWeeklyPay(hoursWorked));		
			System.out.printf("%24s \t %2d \t\t\t %.2f\n", employee.getLastName()+", "+employee.getFirstName(), hoursWorked, employee.calculateWeeklyPay(hoursWorked));
		}
		System.out.println();
		System.out.println("Total hours worked is: " + totalHoursWorked);
		System.out.printf("Total pay is: %.2f" , totalPay );
	}
}
