package com.techelevator;

public class CheckingAccount extends BankAccount {  // we inherit all data and methods of super class (BankAccount)
													// all we provide is any additional data or methods/behavior
   
	// no additional attributes or data provided in this subclass 
	
		// subclass ctor must get data required by superclass and call/invoke superclass ctor
		// super() is used to invoke super class ctor
	
	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance);  // invokes super class 3-arg ctor with data we received 
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);           // invokes super class 2-arg ctor with data we received
    }

    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {                // this overrides withdraw method in BankAccount 
        // Only allow the withdraw if the balance isn't going to go below -$100  // specific to the CheckingAccount class since 
        if (getBalance().minus(amountToWithdraw).getDollars() > -100) {          // CheckingAccount withdraw has different rules
            // Withdraw the $$                                                   // i.e. $10 charge if balance < 0 
            super.withdraw(amountToWithdraw);
            // If the balance dips below 0, assess $10 charge
            if (getBalance().isNegative()) {
                super.withdraw(new DollarAmount(10, 00));
            }
        }
        return getBalance();            
    }
}

