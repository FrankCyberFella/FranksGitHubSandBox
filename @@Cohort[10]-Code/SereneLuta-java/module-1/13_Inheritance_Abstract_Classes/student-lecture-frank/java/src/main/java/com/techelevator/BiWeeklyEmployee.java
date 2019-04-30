package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BiWeeklyEmployee extends Worker {

	List<String> SomeName = new ArrayList<String>();
	
	public BiWeeklyEmployee(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public double calculateIncomeTax(double pay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateWeeklyPay(int numHoursWorked) {
		// TODO Auto-generated method stub
		return 0;
	}
}
