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
		BankAccount aBankAccount = new BankAccount();
		BankAccount anotherAcct = new BankAccount("031952",new BigDecimal("19.95"));
		aBankAccount.setAccountNumber("stuff");
		aBankAccount.deposit(new BigDecimal("20"));
		System.out.println(aBankAccount.getBalance());
		System.out.println(anotherAcct.getBalance());
		System.out.println("transferring $20");
		aBankAccount.transfer(anotherAcct, new BigDecimal("20"));
		System.out.println(aBankAccount.getBalance());
		System.out.println(anotherAcct.getBalance());
		//checking acct
		BankAccount myHSA = new CheckingAccount("0112395",new BigDecimal("52000.19"));
		System.out.println("Checking Account balance: "+myHSA.getBalance());
		myHSA.withdraw(new BigDecimal("52001"));
		System.out.println("Checking Account balance after withdrawing 52001: "+myHSA.getBalance());
		myHSA.withdraw(new BigDecimal("80"));
		System.out.println("Checking Account balance after withdrawing anoter 80: "+myHSA.getBalance());
		//savings acct
		BankAccount myHSB = new SavingsAccount("0112396",new BigDecimal("299"));
		System.out.println("Savings Account balance: "+myHSB.getBalance());
		myHSB.withdraw(new BigDecimal("150"));
		System.out.println("Savings Account balance after withdrawing 150: "+myHSB.getBalance());
		myHSB.withdraw(new BigDecimal("150"));
		System.out.println("Savings Account balance after withdrawing anoter 150: "+myHSB.getBalance());
		
		SavingsAccount myHSC = new SavingsAccount("0112397",new BigDecimal("100"));
		System.out.println("Savings Account balance of $100: "+myHSC.getBalance());
		myHSC.addInterest();
		System.out.printf("Savings Account balance after interest: %.2f",myHSC.getBalance());
		
		BankAccount checkingAccount = new CheckingAccount("0112399", new BigDecimal("5500.00"));
		BankAccount savingsAccount = new SavingsAccount("0112400", new BigDecimal("10000.00"));
		BankCustomer jayGatsby = new BankCustomer();
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingsAccount);
		System.out.println(String.format("\nJay Gatsby has %s accounts.", jayGatsby.getAccounts().length));
		System.out.println("Is VIP: " + jayGatsby.getIsVIP());
	}

}
