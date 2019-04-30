package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {//Creating a child class  // The method must have the same name as in the parent class,The method must have the same parameter as in the parent class. There must be an IS-A relationship (inheritance). 
	private static BigDecimal interestRate = new BigDecimal("0.02");
	
	public SavingsAccount() {
		
	}

	  
	public SavingsAccount(String savingAccount, BigDecimal savingBalance) {
		super(savingAccount, savingBalance);
		
	}
	
	public BigDecimal getInterestRate() { //the getter for name variable
		return interestRate;
		}
	
	private BigDecimal setInterestRate() {
		return interestRate;
	}
	
	@Override
	public BigDecimal withdraw(BigDecimal withdrawAmount) {
		if(withdrawAmount.doubleValue() > this.getBalance().doubleValue()) {
			return this.getBalance();
		}
		else {
			if(this.getBalance().doubleValue() < 150) {
				return this.getBalance().subtract(withdrawAmount.add(new BigDecimal("2")));
			}
		else {
			if(this.getBalance().doubleValue() >= 150) {
				return this.getBalance().subtract(withdrawAmount);
			}
		}
		return this.getBalance();
	}
}
	
	
	public BigDecimal addInterest() {
//		super.addInterest(interestRate);
		BigDecimal interestAmount;
		interestAmount = this.getBalance().multiply(interestRate);
		//this.getBalance().add(interestAmount);
		return this.getBalance().add(interestAmount);
	}
	
	public void showSavingsAccount() {
		System.out.println(this.getBalance());
	}
 }

	
	 

