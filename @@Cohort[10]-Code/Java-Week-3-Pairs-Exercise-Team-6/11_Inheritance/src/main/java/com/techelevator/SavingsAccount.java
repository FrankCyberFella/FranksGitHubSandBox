package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	
	private double savingsBalance = (super.getBalance()).doubleValue();
	private static BigDecimal interestRate = new BigDecimal("0.02");

	public SavingsAccount(String acctNum, BigDecimal balance) {
		super (acctNum, balance);
		}
	
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	private static void setInterestRate(BigDecimal interestRate) {

		SavingsAccount.interestRate = interestRate;
	}

	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if((savingsBalance > amountToWithdraw.doubleValue())) {
			if(savingsBalance < 150.00) {
				return super.withdraw(amountToWithdraw.add(new BigDecimal("2")));
			}
			else return super.withdraw(amountToWithdraw);
			}
		else return super.getBalance();
	}
	
	public BigDecimal addInterest() {
		return super.deposit(super.getBalance().multiply(interestRate));
					
	}
	
}

