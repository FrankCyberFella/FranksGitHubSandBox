package com.techelevator;

public class CheckingAccount extends BankAccount { // inherits all the data and methods of the super class
	// all we provide here is any additional data or methods/behavior
	// no additional attributes or data here
	
// a subclass ctor must get the data required by the super class and call/invoke the superclass ctor.
	// super() -- invokes the super class ctor
	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance); // invoke the super class 3-arg ctor with data we received
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber); // invokes the 2-arg super class ctor with data we received
    }

    @Override // overrides the BankAccount withdraw() method, we need to provide more functionality
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

