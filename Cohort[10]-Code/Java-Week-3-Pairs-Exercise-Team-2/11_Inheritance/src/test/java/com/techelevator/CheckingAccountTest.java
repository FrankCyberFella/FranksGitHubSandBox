package com.techelevator;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;


public class CheckingAccountTest {

	CheckingAccount checking = new CheckingAccount("112245",new BigDecimal("500"));
	
	@Test
	public void withdraw() {
		assertEquals("Failed to withdraw $100",400,checking.withdraw(new BigDecimal("100.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $491",400,checking.withdraw(new BigDecimal("491")).doubleValue(),.001);
		assertEquals("Failed to withdraw $350",350,checking.withdraw(new BigDecimal("50.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $355",-15,checking.withdraw(new BigDecimal("355.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $10",-35,checking.withdraw(new BigDecimal("10.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $60",-35,checking.withdraw(new BigDecimal("60.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $70",-35,checking.withdraw(new BigDecimal("70.0")).doubleValue(),.001);
		assertEquals("Failed to withdraw $55",-100,checking.withdraw(new BigDecimal("55.0")).doubleValue(),.001);
	}

}
