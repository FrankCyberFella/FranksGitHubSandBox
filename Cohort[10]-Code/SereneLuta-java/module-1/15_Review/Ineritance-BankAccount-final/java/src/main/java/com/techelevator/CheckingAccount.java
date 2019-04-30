package com.techelevator;

public class CheckingAccount extends BankAccount { //"extends" means this is a subclass of BankAccount
												   //BankAccount is the superclass
												   //We inherit all data and methods of super class
												   //All we provide is any additional data or methods/behaviors
	
	// no additional data members
	
	// a subclass constructor must get the data required by the super class and call/invoke ths uper class constructor
	//a super() - invokes the super class constructor
	public CheckingAccount(String accountHolder, String accountNumber, DollarAmount balance) {
        super(accountHolder, accountNumber, balance); //invoke the super class 3 arg constructor with data we received
    }												  //this constructor method allows us to access private data

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);		  //invokes the super class 2 arg constructor with data we received
    }												  //this constructor method allows us to access private data

    //We need to override the super class withdraw method because we want to do more than that method does
 
    @Override
    public DollarAmount withdraw(DollarAmount amountToWithdraw) {
        // Only allow the withdraw if the balance isn't going to go below -$100
        if (getBalance().minus(amountToWithdraw).getDollars() > -100) {
            // Withdraw the $$
            super.withdraw(amountToWithdraw); // the super. will access the account that resides in the BankAccount class and actually change the data
            // If the balance dips below 0, assess $10 charge
            if (getBalance().isNegative()) {
                super.withdraw(new DollarAmount(10, 00));
            }
        }
        return getBalance();            
    }
}

