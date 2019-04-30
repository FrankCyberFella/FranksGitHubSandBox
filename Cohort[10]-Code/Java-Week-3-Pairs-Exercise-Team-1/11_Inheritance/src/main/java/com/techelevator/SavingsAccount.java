package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

		private static BigDecimal interestRate = new BigDecimal ("0.02");
		
		
		public SavingsAccount(String acctNum, BigDecimal bal) {
			super(acctNum, bal);
		}
		
		/**
		 * @return the interestRate
		 */
		public BigDecimal getInterestRate() {
			return interestRate;
		}

		public SavingsAccount() {
			super();
			
		}
		private static void setInterestRate(BigDecimal interestRate) {
			SavingsAccount.interestRate = interestRate;
		}
		
		@Override
		public BigDecimal withdraw (BigDecimal amountToWithdraw) {
			if(super.getBalance().subtract(amountToWithdraw).doubleValue() > 2) {
				super.withdraw(amountToWithdraw);
				if(super.getBalance().doubleValue() < 150.00) {
					super.withdraw(new BigDecimal("2.00"));
					}
			}
				return super.getBalance();
		}
		
		
		public BigDecimal addInterest() {
			 return super.deposit(super.getBalance().multiply(interestRate)); 
		}
}
