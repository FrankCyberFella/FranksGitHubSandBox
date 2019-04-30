package com.techelevator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount extends BankAccount implements InterestRate {
	
public SavingsAccount() {
	super();
}

public SavingsAccount(String acctNum, BigDecimal bal) {
	super(acctNum, bal);
}
	
	private static BigDecimal interestRate = new BigDecimal(".02");
	
@Override
public BigDecimal withdraw(BigDecimal amountToWithdraw) {
	
	if(amountToWithdraw.doubleValue() <= getBalance().doubleValue()) {
		if(getBalance().doubleValue()<150.00) {
				super.withdraw(new BigDecimal ("2.00"));
			if(amountToWithdraw.doubleValue() <= getBalance().doubleValue()) {
				super.withdraw(amountToWithdraw);
				return getBalance();
			}
		}
		else if(getBalance().doubleValue() >= 150.00) {
			super.withdraw(amountToWithdraw);
			return getBalance();
		}
	}
	return getBalance();
}

public void addInterest() {
	this.deposit(getBalance().multiply(interestRate).setScale(2, RoundingMode.DOWN));
}
}
