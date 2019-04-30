package com.techelevator;
import java.math.BigDecimal;
public class CheckingAccount extends BankAccount {
	//data members---------------------------
	
	//ctor----------------------------------
	public CheckingAccount() {
		//Just call the superclass constructor with no changes?
		super();
	}
	public CheckingAccount(String acctNum, BigDecimal bal) {
		super(acctNum, bal);
	}
	
	//getters and setters--------------------
	//methods--------------------------------
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().subtract(amountToWithdraw).doubleValue()>=-90) {
			super.withdraw(amountToWithdraw);
			if(super.getBalance().doubleValue()<0.00) {
				super.withdraw(new BigDecimal("10.00"));
			} 
		}
		return super.getBalance();
	}
	
}

