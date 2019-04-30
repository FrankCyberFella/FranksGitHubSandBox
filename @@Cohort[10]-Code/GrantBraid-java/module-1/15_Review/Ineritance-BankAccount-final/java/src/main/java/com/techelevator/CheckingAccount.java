package com.techelevator;

public class CheckingAccount extends BankAccount {	// extends means this is a subclass of BankAccount
													// BankAccount is the super class
													// we inherit all data and methods of super class
													// All we provide is any additional data of methods/behaviour
	// no additional attributes / data
	
	// a subclass ctor must get the data required by the superclass and call/invoke the superclass ctor
	// super() - invoke the superclass ctor

	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance); // invoke the super class 3-arg ctor with data we received
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);		  // invoke the super class 2-arg ctor with data we received
    }

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

