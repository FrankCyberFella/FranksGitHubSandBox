package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTest {
	
	@Test
	public void testBankAccount() {
		BankAccount defaultBankAcct = new BankAccount();
		assertEquals("Default account number should be: unknown", "unknown", defaultBankAcct.getAccountNumber());
		assertEquals("Expecting balance of 0.0", new BigDecimal("0.0"), defaultBankAcct.getBalance());
	}
	
	@Test
	public void testBankAccountCtor() {
		BankAccount bankAccountCtor = new BankAccount("12345", new BigDecimal("100.00"));
		assertEquals("Account number should be: 12345", "12345", bankAccountCtor.getAccountNumber());
		assertEquals("Account balance should be 100.00", new BigDecimal("100.00"), bankAccountCtor.getBalance());
	}
	
	@Test
	public void testDeposit() {
		BankAccount exercise = new BankAccount("12345", new BigDecimal("1000.00"));
		assertEquals(new BigDecimal("1999.99"), exercise.deposit(new BigDecimal("999.99")));
	}
	
	@Test
	public void testBankAccountWithdraw() {
		BankAccount exercise = new BankAccount("12345", new BigDecimal("1000.00"));
		assertEquals("New balance should be 400.00", new BigDecimal("400.00"), exercise.withdraw(new BigDecimal("600.00")));
	}
	
	@Test
	public void testBankAccountTransfer() {
		BankAccount exercise = new BankAccount("12345", new BigDecimal("1400.00"));
		BankAccount accountTwo = new BankAccount("0987", new BigDecimal("750.00"));
		assertEquals("New balance should be ", new BigDecimal("900.00"), exercise.transfer(accountTwo, new BigDecimal("500.00")));
		assertEquals("Destination account balance should be 1250.00", new BigDecimal("1250.00"), accountTwo.getBalance());
	}
	
	@Test
	public void testCheckingCtor() {
		CheckingAccount testCheckAccount = new CheckingAccount("9876", new BigDecimal("444.00"));
		assertEquals("Account number should be 9876", "9876", testCheckAccount.getAccountNumber());
		assertEquals("Account balance should be 444.00", new BigDecimal("444.00"), testCheckAccount.getBalance());
	}

	@Test
	public void testWithdrawSimple() {
		CheckingAccount testCheckAccount = new CheckingAccount("9876", new BigDecimal("444.00"));
		assertEquals("New balance should be 344.00", new BigDecimal("344.00"), testCheckAccount.withdraw(new BigDecimal("100.00")));
	}
	
	@Test
	public void testWithdrawExcessOverdraw() {
		CheckingAccount testCheckAccount = new CheckingAccount("9876", new BigDecimal("444.00"));
		assertEquals("Resulting balance should be 444.00", new BigDecimal("444.00"), testCheckAccount.withdraw(new BigDecimal("600.00")));
	}
	
	@Test
	public void testWithdrawSmallOverdraw() {
		CheckingAccount testCheckAccount = new CheckingAccount("9876", new BigDecimal("100.00"));
		assertEquals("Balance should be -60.00", new BigDecimal("-60.00"), testCheckAccount.withdraw(new BigDecimal("150.00")));
	}
	
	@Test
	public void testSavingsCtor(){
		SavingsAccount testSavings = new SavingsAccount("9876", new BigDecimal("250.00"));
		assertEquals("Account number should be 9876", "9876", testSavings.getAccountNumber());
		assertEquals("Account balance should be 250.00", new BigDecimal("250.00"), testSavings.getBalance());
	}
	
	@Test
	public void testSavingsWithdrawSimple(){
		SavingsAccount testSavings = new SavingsAccount("9876", new BigDecimal("250.00"));
		assertEquals("Balance should be 150.00", new BigDecimal("150.00"), testSavings.withdraw(new BigDecimal("100.00")));
	}
	
	@Test
	public void testSavingsWithdrawServiceFee(){
		SavingsAccount testSavings = new SavingsAccount("9876", new BigDecimal("100.00"));
		assertEquals("Balance should be 48.00", new BigDecimal("48.00"), testSavings.withdraw(new BigDecimal("50.00")));
	}
	
	@Test
	public void testSavingsWithdrawFail(){
		SavingsAccount testSavings = new SavingsAccount("9876", new BigDecimal("200.00"));
		assertEquals("Balance should be 200.00", new BigDecimal("200.00"), testSavings.withdraw(new BigDecimal("201.00")));
	}
	
	@Test
	public void testSavingsInterest(){
		SavingsAccount testSavings = new SavingsAccount("9876", new BigDecimal("100.00"));
		assertEquals("Balance should be 102.00", new BigDecimal("102.00"), testSavings.addInterest().setScale(2,RoundingMode.DOWN));
	}
	
	@Test
	public void testBankCustomerCtor() {
		BankCustomer andyDevine = new BankCustomer("Devine", "12 Pine St", "216-855-7463");
		assertEquals("Customer name should be Devine", "Devine", andyDevine.getName());
		assertEquals("Customer address should be 12 Pine St", "12 Pine St", andyDevine.getAddress());
		assertEquals("Customer phone number should be 216-855-7463", "216-855-7463", andyDevine.getPhoneNumber());
	}
	
	@Test
	public void testGetIsVipTrue() {
		BankCustomer andyDevine = new BankCustomer("Devine", "12 Pine St", "216-855-7463");
		BankAccount checkingAccount = new CheckingAccount("24-987", new BigDecimal("45666"));
		BankAccount savingsAccount = new SavingsAccount("24-456", new BigDecimal("102000"));
		andyDevine.addAccount(checkingAccount);
		andyDevine.addAccount(savingsAccount);
		assertTrue("Customer is VIP", andyDevine.getIsVIP());
	}
	
	@Test
	public void testGetIsVipFalse() {
		BankCustomer andyDevine = new BankCustomer("Devine", "12 Pine St", "216 -855-7463");
		BankAccount checkingAccount = new CheckingAccount("24-987", new BigDecimal("1000"));
		BankAccount savingsAccount = new SavingsAccount("24-456", new BigDecimal("12000"));
		andyDevine.addAccount(checkingAccount);
		andyDevine.addAccount(savingsAccount);
		assertFalse("Customer is not VIP", andyDevine.getIsVIP());
	}
}
