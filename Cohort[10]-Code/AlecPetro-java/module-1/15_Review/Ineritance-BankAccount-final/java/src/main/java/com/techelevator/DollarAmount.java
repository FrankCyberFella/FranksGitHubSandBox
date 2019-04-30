package com.techelevator;

public class DollarAmount {
    //************************************************************************************************
    // constants and class data - one copy of this data - all instance share and can't change
    //************************************************************************************************
	
    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0); // constant to represent a zero amount
    
    //************************************************************************************************
    // member data - instance data - each instance of the class gets one copy of this data
    //************************************************************************************************
    
    private int totalAmountInCents;
    
    //************************************************************************************************
    // ctors
    //************************************************************************************************
    
    public DollarAmount(int totalAmountInCents) { // method receives one-int-param and has no return
    												// same name as class and has no-return = ctor
        this.totalAmountInCents = totalAmountInCents; // initialize member data
    }
    public DollarAmount(int dollars, int cents) { // 2-arg ctor - receives two ints
        totalAmountInCents = (dollars * 100) + cents; // initialize data member with values
    }
    
    //************************************************************************************************
    // member functions - behavior
    //************************************************************************************************
    
    
    //************************************************************************************************
    // getters
    //************************************************************************************************
    
    public int getTotalAmountInCents() {
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    
    //************************************************************************************************
    // methods to compare objects of the class
    //************************************************************************************************
    
    public boolean isGreaterThan(DollarAmount amountToCompare) {
        return this.totalAmountInCents > amountToCompare.totalAmountInCents;
    }
    
    public boolean isGreaterThanOrEqualTo(DollarAmount amountToCompare) {
        return this.totalAmountInCents >= amountToCompare.totalAmountInCents;
    }
    
    public boolean isLessThan(DollarAmount amountToCompare) {
        return this.totalAmountInCents < amountToCompare.totalAmountInCents;
    }
    
    public boolean isLessThanOrEqualTo(DollarAmount amountToCompare) {
        return this.totalAmountInCents <= amountToCompare.totalAmountInCents;
    }
    
    public boolean isNegative() {
        return totalAmountInCents < 0;
    }
    
    public DollarAmount minus(DollarAmount amountToSubtract) {
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }

    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1;
        } else if(this.isLessThan(amountToCompare)) {
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof DollarAmount) {
            return this.totalAmountInCents == ((DollarAmount)obj).totalAmountInCents;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
    	return totalAmountInCents;
    }
    
    @Override
    public String toString() {
        long absAmount = Math.abs(totalAmountInCents);
        StringBuilder str = new StringBuilder();
        if(totalAmountInCents < 0) {
                str.append("-");
        }
        str.append("$");
        if(absAmount >= 100) {
                str.append(absAmount / 100);
        } else {
                str.append("0");
        }
        str.append(".");
        if(absAmount % 100 < 10) {
                str.append("0");
        }
        str.append(absAmount % 100);
        return str.toString();
    }

}
