package com.techelevator;

public class SavingsAccount extends BankAccount implements InterestAccount{
	
    public SavingsAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }
// we need to override the withdraw() in super class since we ant to do something different
    
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
    
    public DollarAmount addInterest() {
    	double interest = 0.0;  //initialize interest to zero.
    	//multiply the balance in the account by the interest rate
    		interest = super.getBalance().getTotalAmountInCents() * intRate;
    		
    		// Update the balance with interest (add interest to balance)
    		super.deposit(new DollarAmount((int)interest));
    		//return the new balance
    		return super.getBalance();  // don't need the word super because we are in a subclass of bank account
    		//we have access the super class method getBalance....  BUT...it is a good idea to use it for clarity.
    }
}
