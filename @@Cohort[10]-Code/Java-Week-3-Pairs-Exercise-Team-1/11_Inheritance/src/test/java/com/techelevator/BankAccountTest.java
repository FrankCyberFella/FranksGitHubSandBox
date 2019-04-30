package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountTest {
	
	
	
	
	@Test
	public void getAccountNumber() {
		BankAccount exercises = new BankAccount();
		assertEquals("unknown", exercises.getAccountNumber());
	}
	@Test
	public void setAccountNumber() {
		BankAccount exercises = new BankAccount();
		exercises.setAccountNumber(new String ("1234"));
		assertEquals(new String ("1234"), exercises.getAccountNumber());
	}
	@Test
	public void getBalance() {
		BankAccount exercises = new BankAccount();
		assertEquals(new BigDecimal ("0.00"), exercises.getBalance());
	}
	@Test
	public void Default_Bank_Account() {
		BankAccount exercises = new BankAccount();
		assertEquals(new String ("unknown"), exercises.getAccountNumber());
		assertEquals(new BigDecimal ("0.00"), exercises.getBalance());
	}
	@Test
	public void Bank_Account_Set() {
		BankAccount exercises = new BankAccount("12345", new BigDecimal ("100.00"));
		assertEquals(new String ("12345"), exercises.getAccountNumber());
		assertEquals(new BigDecimal ("100.00"), exercises.getBalance());
	}
	@Test
	public void deposit() {
		BankAccount exercises = new BankAccount();
		exercises.deposit(new BigDecimal ("25.00"));
		assertEquals(new BigDecimal ("25.00"), exercises.getBalance());
	}
	@Test
	public void withdraw() {
		BankAccount exercises = new BankAccount("12345", new BigDecimal ("100.00"));
		exercises.withdraw(new BigDecimal ("20.00"));
		assertEquals(new BigDecimal ("80.00"), exercises.getBalance());
		
		CheckingAccount exercises2 = new CheckingAccount("12345", new BigDecimal ("100.00"));
		exercises2.withdraw(new BigDecimal ("110.00"));
		assertEquals(new BigDecimal ("-20.00"), exercises2.getBalance());
		
		CheckingAccount exercises3 = new CheckingAccount("123456", new BigDecimal ("100.00"));
		exercises3.withdraw(new BigDecimal ("250.00"));
		assertEquals(new BigDecimal ("100.00"), exercises3.getBalance());
		
		SavingsAccount exercises4 = new SavingsAccount("1234567", new BigDecimal ("100.00"));
		exercises4.withdraw(new BigDecimal ("10.00"));
		assertEquals(new BigDecimal ("88.00"), exercises4.getBalance());
		
		SavingsAccount exercises5 = new SavingsAccount("12345678", new BigDecimal ("160.00"));
		exercises5.withdraw(new BigDecimal ("10.00"));
		assertEquals(new BigDecimal ("150.00"), exercises5.getBalance());
	}
	@Test
	public void transfer() {
		SavingsAccount exercises = new SavingsAccount("12345", new BigDecimal ("100.00"));
		CheckingAccount exercises1 = new CheckingAccount("54321", new BigDecimal("50.00"));
		exercises.transfer(exercises1, new BigDecimal ("25.00"));
		assertEquals(new BigDecimal ("75.00"), exercises.getBalance());
		assertEquals(new BigDecimal ("75.00"), exercises1.getBalance());
		
		SavingsAccount exercises2 = new SavingsAccount("67890", new BigDecimal ("100.00"));
		CheckingAccount exercises3 = new CheckingAccount("09876", new BigDecimal("50.00"));
		exercises3.transfer(exercises2, new BigDecimal ("25.00"));
		assertEquals(new BigDecimal ("25.00"), exercises3.getBalance());
		assertEquals(new BigDecimal ("125.00"), exercises2.getBalance());
	}
}
