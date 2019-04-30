package com.techelevator;
import java.math.BigDecimal;
import org.junit.Test;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;

public class Bank_TellerTest {
	
	BankAccount account = new BankAccount("1029384", new BigDecimal("100"));

	@Test
	public void getBalance() {
		
		assertEquals("Incorrect balance", 100, account.getBalance().doubleValue(),.001);
	}

	@Test
	public void getAccountNumber() {
		
		assertEquals("Invalid account number", "1029384", account.getAccountNumber());
	}
	
	@Test
	public void setAccountNumber() {
		account.setAccountNumber("Bob");
		assertEquals("Unable to process request", "Bob", account.getAccountNumber());
	}
	
	@Test
	public void deposit() {
		assertEquals("Unable to deposit", 200.00, account.deposit(new BigDecimal("100.00")).doubleValue(), 0.001);
	}
	
	@Test
	public void withdraw() {
		assertEquals("Unable to withdraw", 50.00, account.withdraw(new BigDecimal("50.00")).doubleValue(), 0.001);
	}
	
	@Test
	public void transfer() { 
		BankAccount destinationAccount = new BankAccount("1039745", new BigDecimal("1000.00"));
		account.transfer(destinationAccount, new BigDecimal("10.00"));
		assertEquals("Unable to transfer into account", 1010.00, destinationAccount.getBalance().doubleValue(), 0.001);
		assertEquals("Unable to transfer from account", 90.00, account.getBalance().doubleValue(), 0.001);
	}
	
	
	
}
