package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	
	private double checkingBalance = (super.getBalance()).doubleValue();
	

public CheckingAccount(String acctNum, BigDecimal balance) {
	super (acctNum, balance);

	}

@Override
public BigDecimal withdraw(BigDecimal amountToWithdraw) {
	
	if((checkingBalance > amountToWithdraw.doubleValue() - 100)) {
		if(checkingBalance - amountToWithdraw.doubleValue() < 0) {
			return super.withdraw(amountToWithdraw.add(new BigDecimal("10")));
		}
		else return super.withdraw(amountToWithdraw);
		}
	else return super.getBalance();
	}

	public BigDecimal addInterest() {
		return super.deposit(new BigDecimal("0"));				
	}

}