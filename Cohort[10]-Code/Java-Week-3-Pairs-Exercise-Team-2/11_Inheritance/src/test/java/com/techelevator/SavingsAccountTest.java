package com.techelevator;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;


public class SavingsAccountTest {
	
	SavingsAccount account = new SavingsAccount("102938", new BigDecimal("1000"));

	@Test
	public void withdraw() {
		assertEquals("Unable to withdraw $100", 900, account.withdraw(new BigDecimal("100.00")).doubleValue(), 0.001);
		assertEquals("Unable to withdraw $800", 98, account.withdraw(new BigDecimal("800.00")).doubleValue(), 0.001);
		assertEquals("Unable to withdraw $42", 54, account.withdraw(new BigDecimal("42.00")).doubleValue(), 0.001);
		assertEquals("Unable to withdraw $53", 54, account.withdraw(new BigDecimal("53.00")).doubleValue(), 0.001);
		assertEquals("Unable to withdraw $55", 54, account.withdraw(new BigDecimal("55.00")).doubleValue(), 0.001);
	}

	@Test
	public void addInterest() {
		assertEquals("Unable to add interest",1020,account.addInterest().doubleValue(),.001);
	}
	
}
