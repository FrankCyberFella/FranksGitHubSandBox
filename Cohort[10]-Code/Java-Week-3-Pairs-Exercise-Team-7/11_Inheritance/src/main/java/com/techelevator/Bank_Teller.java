package com.techelevator;

import java.math.BigDecimal;

public class Bank_Teller {

	public static void main(String[] args) {
	//Testing BankAccount, SavingsAccount, CheckingAccount classes	
	BankAccount Sam = new BankAccount("1234124", new BigDecimal ("100.00"));
	BankAccount Cyrus = new BankAccount();
	CheckingAccount Frank = new CheckingAccount();
	SavingsAccount Bobby = new SavingsAccount();
	
	//invoking methods
		Cyrus.deposit(new BigDecimal("178.56"));
		Cyrus.showAccountBalance();
		Sam.withdraw(new BigDecimal("10.00"));
		Cyrus.transfer(Sam, new BigDecimal("50.01"));
		Sam.showAccountBalance();
		
		Frank.deposit(new BigDecimal("50.00"));
		Frank.withdraw(new BigDecimal("51.00"));
		Frank.showAccountBalance();
		
		Bobby.deposit(new BigDecimal("200.00"));
		Bobby.withdraw(new BigDecimal("51.00"));
		Bobby.withdraw(new BigDecimal("1.00"));
		Bobby.addInterest();
		Bobby.showAccountBalance();
	
	
	//Testing BankCustomer Buddy
	BankCustomer Buddy = new BankCustomer();
	CheckingAccount checkingAccount = new CheckingAccount();
	SavingsAccount savingsAccount = new SavingsAccount();
	BankAccount bankAccount = new BankAccount();
	Buddy.addAccount(savingsAccount);
	Buddy.addAccount(checkingAccount);
	Buddy.setName("Buddy Bones");
	savingsAccount.deposit(new BigDecimal("10000.00"));
	checkingAccount.deposit(new BigDecimal("10000.00"));
	System.out.println(String.format("Buddy has %s accounts. ", Buddy.getAccounts().size()));
	System.out.println("Is Buddy a vip? " + Buddy.getIsVip());
	
	
	
	//Testing BankCustomer Craig and seeing getIsVip() method
	CheckingAccount craigChecking = new CheckingAccount();
	SavingsAccount  craigSavings = new SavingsAccount();
	BankCustomer    Craig = new BankCustomer();
	Craig.addAccount(craigSavings);
	Craig.addAccount(craigChecking);
	Craig.setName("Craig Costelez");
	Craig.setPhoneNumber("555-555-5555");
	craigSavings.deposit(new BigDecimal("1000"));
	craigChecking.deposit(new BigDecimal("15000"));
	System.out.println(Craig.getName() + "'s balance is " + Craig.totalBalance() + " and is VIP? " + Craig.getIsVip());
	
	
	
	}
}
