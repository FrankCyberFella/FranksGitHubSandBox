package com.techelevator;

public class DollarAmount {
	//**************************************************************************************************
    //constants and class data - one copy of this data that all instances share and can't change
    //**************************************************************************************************

    public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0); // constant to represent a zero amount
    //**************************************************************************************************
    //member data - instance data - each instance of the class gets one copy of this data
    //**************************************************************************************************
    private int totalAmountInCents;
    
    public DollarAmount(int totalAmountInCents) { // method receives one-int-parameter and has no return
    											// same name as class and has no return = constructor
        this.totalAmountInCents = totalAmountInCents;  // initialize member data to what was passed
    }
  //**************************************************************************************************
    //member functions - behavior
    //**************************************************************************************************
    public DollarAmount(int dollars, int cents) {      //2 argument constructor, receives two ints
        totalAmountInCents = (dollars * 100) + cents;
    }
  //**************************************************************************************************
    //getters
    //**************************************************************************************************
    
    public int getTotalAmountInCents() {
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
  //**************************************************************************************************
    //methods to compare objects of the class
    //**************************************************************************************************
    
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
  //**************************************************************************************************
    //method to ask if value is negative
    //**************************************************************************************************
    public boolean isNegative() {
        return totalAmountInCents < 0;
    }
  //**************************************************************************************************
    //methods that perform simple arithmetic
    //**************************************************************************************************
    
    public DollarAmount minus(DollarAmount amountToSubtract) {
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }
  //**************************************************************************************************
    //method used with a Java Comparator class
    //**************************************************************************************************
    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1; //return 1 if the first is greater than the second
        } else if(this.isLessThan(amountToCompare)) {
            return -1; // return -1 if the first is less than the second
        } else {
            return 0; // return 0 if they are equal
        }
    }
  //**************************************************************************************************
    //Object class overrides--performs common Java processing with the object
    //**************************************************************************************************
    
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
