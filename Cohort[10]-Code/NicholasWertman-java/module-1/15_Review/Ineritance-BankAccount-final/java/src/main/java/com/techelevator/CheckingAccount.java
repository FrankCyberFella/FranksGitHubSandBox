package com.techelevator;

public class CheckingAccount extends BankAccount {	//extends means this is a subclass of BankAccount
													//BankAccount is the superclass
													// inherit all data and methods from superclass
													//we just provide any additional data or methods
	
//no additional attributes or data
	
	//a subclass constructor must get the data required by the super class and call/invoke super ctor
	// super () --> invoke superclass ctor 

	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);	//invoke super class 3 arg ctor
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);		//invoke super class 2 arg ctor
    }

    // need to override superclass withdraw method to allow us to do more than what it does for checking
    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {
        // Only allow the withdraw if the balance isn't going to go below -$100
        if (getBalance().minus(amountToWithdraw).getDollars() > -100) {
            // Withdraw the $$
            super.withdraw(amountToWithdraw);
            // If the balance dips below 0, assess $10 charge
            if (getBalance().isNegative()) {
                super.withdraw(new DollarAmount(10, 00));
            }
        }
        return getBalance();            
    }
}

