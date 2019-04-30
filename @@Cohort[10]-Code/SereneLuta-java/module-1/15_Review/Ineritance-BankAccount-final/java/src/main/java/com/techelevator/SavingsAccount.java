package com.techelevator;

public class SavingsAccount extends BankAccount implements InterestAccount {
	
    public SavingsAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    //We need to override the withdraw() in super class since we want to do something different
    
    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {
        // only perform transaction of positive $
        if (!getBalance().minus(amountToWithdraw).isNegative()) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance().getDollars() < 150) {
                super.withdraw(new DollarAmount(200));
            }                
        }
        return getBalance();
    }

	@Override
	public DollarAmount addInterest() {
		double interest = 0; // initialize interest to zero
		//Multiply the balance in the account by the interest rate
		interest = super.getBalance().getTotalAmountInCents() * intRate;
		//Update balance with the interest amount (add interest to balance)
		super.deposit(new DollarAmount((int)interest));
		//Return the balance
		return null;
	}
}
