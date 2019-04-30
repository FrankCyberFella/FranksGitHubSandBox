package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	//data members---------------------------
	private static BigDecimal interestRate = new BigDecimal(.02);//
	//ctor----------------------------------
	public SavingsAccount() {
		//Just call the superclass constructor with no changes?
		super();
	}
	public SavingsAccount(String acctNum, BigDecimal bal) {
		super(acctNum, bal);
	}
	//getters and setters--------------------
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	private static void setInterestRate(BigDecimal interestRate) {
		SavingsAccount.interestRate = interestRate;
	}
	
	//methods--------------------------------
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		if(super.getBalance().subtract(amountToWithdraw).doubleValue()>2) {
			super.withdraw(amountToWithdraw);
			if(super.getBalance().doubleValue()<150.00) {
				super.withdraw(new BigDecimal("2.00"));
			} 
		}
		return super.getBalance();
	}
	public BigDecimal addInterest() {
		return super.deposit(super.getBalance().multiply(interestRate)); //deposit does the addition
	}
}
