package com.techelevator;

import java.math.BigDecimal;

public class Bank_Teller {

	public static void main(String[] args) {

	/****************************************************************************
	 * 
	 * Use this application program to test your classes.
	 * 
	 * You should instantiate objects of your class using each of the ctors
	 * created for the class.
	 * 
	 * Use those objects to test each of the methods you have for a class.
	 * 
	 * (Hint: The exercise description has "Sample usage", feel free to use)
	 * 
	 * Consider adding a "show()" method to each class which will display the
	 * values in the data members of the object used to invoke it to make it
	 * easy to verify the processing of your methods
	 * 
	 ****************************************************************************
	 */

		
		
	BigDecimal testBalance = new BigDecimal("25000");	
		
	BankAccount jayGatsbySavings1 = new SavingsAccount("Jay Gatsby Savings Account #1", testBalance);
	BankAccount jayGatsbyCheckings1 = new CheckingAccount("Jay Gatsby Checking Account #2", testBalance);
	
	jayGatsbySavings1.addInterest();
	jayGatsbyCheckings1.withdraw(new BigDecimal ("510"));
	
	System.out.println(jayGatsbyCheckings1.toString());
	//System.out.println(test2.toString());
	
	BankAccount jayGatsbySavings2 = new SavingsAccount("Jay Gatsby Savings Account #2", testBalance);
	BankAccount jayGatsbyCheckings2 = new CheckingAccount("Jay Gatsby Checking Account #2", testBalance);
	
	BankCustomer jayGatsby = new BankCustomer();
	jayGatsby.addAccount(jayGatsbySavings2);
	jayGatsby.addAccount(jayGatsbyCheckings1);
	
	System.out.println(String.format("Jay Gatsby has %s accounts.", jayGatsby.getAccounts().size()));
	System.out.println("Jay Gatsby VIP status is: " + jayGatsby.getIsVIP(jayGatsby.getAccounts()));
	
	System.out.println(jayGatsby.getAccounts());
	}

}
