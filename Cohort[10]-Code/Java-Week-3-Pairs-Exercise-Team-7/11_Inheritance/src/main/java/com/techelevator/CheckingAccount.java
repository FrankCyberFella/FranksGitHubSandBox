package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	//BigDecimal balance = super.getBalance();
	BigDecimal overdraftFee = new BigDecimal("10");
	
public CheckingAccount() {
	super();
}
public CheckingAccount(String acctNum, BigDecimal bal) {
	super(acctNum, bal);
}
@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
	
		if(amountToWithdraw.doubleValue() <= getBalance().doubleValue()) {
			 super.withdraw(amountToWithdraw);
			 return getBalance();
		}
		else {
			if((getBalance().doubleValue() - amountToWithdraw.doubleValue()) < 0.00 &&
				(getBalance().doubleValue() - amountToWithdraw.doubleValue()) >= -100.00) {
			super.withdraw(overdraftFee);
			return getBalance();
			}
		}
		return getBalance();
	}
	
}
