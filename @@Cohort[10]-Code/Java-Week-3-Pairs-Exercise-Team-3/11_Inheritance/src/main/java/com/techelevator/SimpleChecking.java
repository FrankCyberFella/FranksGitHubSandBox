package com.techelevator;

import java.math.BigDecimal;

public class SimpleChecking extends BankAccount { 
	
	public SimpleChecking() { //defult constructor for simplechecking  
		super();
	}
	
	public SimpleChecking(String simpleAccount, BigDecimal simpleBalance) {
		
		super(simpleAccount, simpleBalance);
	}
	@Override 
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(getBalance().subtract(amountToWithdraw).doubleValue() > -100.00) {
			super.withdraw(amountToWithdraw);
			if(getBalance().doubleValue() < 0.0) {
				super.withdraw(new BigDecimal("10.00"));
			}
		}
		return getBalance();
	}
	
}

	
