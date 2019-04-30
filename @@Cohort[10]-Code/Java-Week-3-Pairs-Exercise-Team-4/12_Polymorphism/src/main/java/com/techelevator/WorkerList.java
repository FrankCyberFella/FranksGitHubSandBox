package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerList {

	public static void main(String[] args) {
	
		double totalWeeklyPay = 0.0;
		int totalWeeklyHour = 0;
		List<Worker> workerList = new ArrayList<Worker>();
		Map<String, Integer> hoursWorked = new HashMap<String, Integer>();
		
		Worker Mike = new SalaryWorker("Mike","Boon",50000);
		Worker Steve = new HourlyWorker("Steve","Fult", 30);
		Worker Bob = new VolunteerWorker("Bob","Mome");
		
		workerList.add(Mike);
		workerList.add(Steve);
		workerList.add(Bob);
		
		hoursWorked.put("Mike", 90);
		hoursWorked.put("Steve", 130);
		hoursWorked.put("Bob",50);
		
		
		for (Worker aWorker: workerList) {
			double weeklyPay = 0.0;	
			totalWeeklyPay += aWorker.calculateWeeklyPay(hoursWorked.get(aWorker.getFirstName()));
			totalWeeklyHour += hoursWorked.get(aWorker.getFirstName());
			weeklyPay = aWorker.calculateWeeklyPay(hoursWorked.get(aWorker.getFirstName()));
			System.out.println(aWorker.getFirstName() + ", Hours Worker: " + hoursWorked.get(aWorker.getFirstName()) + " Weekly Pay: " + weeklyPay);
		}
		
		System.out.println("\nTotal Hours: " + totalWeeklyHour + "\nTotal Pay: " + totalWeeklyPay);
		

		
	}
}
