package com.techelevator;

import java.math.BigDecimal;

public class Bank_Teller {

	public static void main(String[] args) {
		
	/*	BankAccount bank1 = new BankAccount();
		BankAccount bank2 = new BankAccount("1111", new BigDecimal("20.00"));
		
		bank1.setAccountNumber("1234");
		bank1.deposit(new BigDecimal("10.00"));
		bank1.withdraw(new BigDecimal("5.50"));
		bank2.transfer(bank1, new BigDecimal("10.00"));
		
		CheckingAccount acct1 = new CheckingAccount("12345", new BigDecimal("13.78"));
		System.out.println("Account " + acct1.getAccountNumber() + " has $" + acct1.getBalance());
		acct1.withdraw(new BigDecimal("15.00"));
		System.out.println("Account " + acct1.getAccountNumber() + " has $" + acct1.getBalance());
		acct1.withdraw(new BigDecimal("100.00"));
		System.out.println("Account " + acct1.getAccountNumber() + " has $" + acct1.getBalance());
		
		SavingsAccount saving1 = new SavingsAccount("123", new BigDecimal("16.78"));
		saving1.withdraw(new BigDecimal("20.00"));
		System.out.println(saving1.getBalance());
		//BigDecimal interest = saving1.addInterest();
		//System.out.println(interest);
		saving1.addInterest();
		System.out.println(saving1.getBalance());
		*/
		
		BankAccount checkingAccount = new CheckingAccount("1234",new BigDecimal("10000"));
		BankAccount savingAccount = new SavingsAccount("123",new BigDecimal("16000"));
		BankCustomer jayGatsby = new BankCustomer();
		
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingAccount);
		

		jayGatsby.getAccounts();
		System.out.println(jayGatsby.getIsVip());


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

	}

}
