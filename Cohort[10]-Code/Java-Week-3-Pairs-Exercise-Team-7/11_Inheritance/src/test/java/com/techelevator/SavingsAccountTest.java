package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.*;
import org.junit.Test;


public class SavingsAccountTest {
	
	SavingsAccount savingsAccountTest = new SavingsAccount("1234", new BigDecimal("500.00"));
	
@Test
public void testWithdrawLessThanBalance() {
Assert.assertEquals("That is not the expected result.", new BigDecimal("250.01"), savingsAccountTest.withdraw(new BigDecimal("249.99")));
}	

@Test
public void testWithdrawMoreThanBalance() {
Assert.assertEquals("That is not the expected result.", new BigDecimal("500.00"), savingsAccountTest.withdraw(new BigDecimal("599.99")));
}	

@Test

public void testWithdrawAndSurcharge() {
	savingsAccountTest.withdraw(new BigDecimal("351.00"));
Assert.assertEquals("That is not the expected result.", new BigDecimal("137.00"), savingsAccountTest.withdraw(new BigDecimal("10.00")));
}	

@Test
public void testWithdrawFailAndSurcharge() {
	savingsAccountTest.withdraw(new BigDecimal("351.00"));
Assert.assertEquals("That is not the expected result.", new BigDecimal("147.00"), savingsAccountTest.withdraw(new BigDecimal("148.00")));
}

@Test
public void testAddInterest() {
	savingsAccountTest.addInterest();
	Assert.assertEquals("That is not the expected result.", new BigDecimal("510.00"), savingsAccountTest.getBalance());
}
	

}
