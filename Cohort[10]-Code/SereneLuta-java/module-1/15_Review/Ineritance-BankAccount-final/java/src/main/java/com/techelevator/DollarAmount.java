package com.techelevator;

public class DollarAmount {
	//***********************************************************************
    //contstants and class data - one copy of this data - all instances share and can't change
    //***********************************************************************

    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0); // constant to represent a zero amount
    
    //***********************************************************************
    //member data - instance data - each instance of the class gets on copy of this data
    //***********************************************************************

    private int totalAmountInCents;
    
    //***********************************************************************
    //Constructor
    //***********************************************************************

    
    public DollarAmount(int totalAmountInCents) { //1 argument constructor, receives one int and has not return
        this.totalAmountInCents = totalAmountInCents; // initialize data member with values passed
    }

    public DollarAmount(int dollars, int cents) { //2 argument constructor, receives two ints and has not return
        totalAmountInCents = (dollars * 100) + cents; // initialize data member with values passed
    }
    
    //***********************************************************************
    //member functions - behaviors
    //***********************************************************************
    
    //***********************************************************************
    //getters
    //***********************************************************************


    public int getTotalAmountInCents() {
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    //***********************************************************************
    //Methods to compare objects of the class
    //***********************************************************************

    
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
    
    //***********************************************************************
    //Methods to ask if the value is negative
    //***********************************************************************
    public boolean isNegative() {
        return totalAmountInCents < 0;
    }
    
    //***********************************************************************
    //Methods to do simple arithmetic
    //***********************************************************************
    
    public DollarAmount minus(DollarAmount amountToSubtract) {
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }
    
    //***********************************************************************
    //Method used with a Java Comparator
    //***********************************************************************

    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1;	//return one if the first is greater than the second
        } else if(this.isLessThan(amountToCompare)) {
            return -1;	// return -1 if the first is less than the second
        } else {
		     return 0;  // return 0 if they are equal		
		       }	
    }
    
    //***********************************************************************
    //Object class overrides we can perform common Java processing with our object
    //***********************************************************************

    
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
