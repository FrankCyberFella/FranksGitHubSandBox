package com.techelevator;

public class SavingsAccount extends BankAccount implements interestAccount {
	
    public SavingsAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

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
    	double interest = 0.0; // initialize interest to zero
    	//Mulitiply the balance in the account by interest rate
    	interest =  super.getBalance().getTotalAmountInCents() * intRate; 
    	//Update the balance with interest(add interest to balance)
    	super.deposit(new DollarAmount((int)interest));
    	//Return the new balance
    	//you don't need the .super here, but it makes it clear that you are using the base class. 
    	//If you have a .getBalance method in this class (Savings account)
    	//then you would need to specify which method you need.
    	return super.getBalance();
    }
}
