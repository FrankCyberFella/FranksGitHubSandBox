package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	
	
	public CheckingAccount() {
		super();
		
		}
	public CheckingAccount(String acctNum, BigDecimal bal) {
		super(acctNum, bal);
	}
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		BigDecimal holder;
		
		if(super.getBalance().subtract(amountToWithdraw).doubleValue() < -100.00) {
			return super.getBalance();
		}
		if(super.getBalance().doubleValue() < (amountToWithdraw.doubleValue())) {
			holder = super.withdraw(amountToWithdraw.add(new BigDecimal("10.00")));
				return holder;
		}
			return super.withdraw(amountToWithdraw);
		
	}
	

}
