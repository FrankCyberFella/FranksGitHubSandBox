package com.techelevator;

public class DollarAmount {
	//*********************************************************************************************************
    // 	CONSTANCS AND CLASS DATA --> ONE COPY OF THIS DATA - ALL INSTANCES SHARE AND CAN'T CHANGE 
    //*********************************************************************************************************
   
	public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0);	//constant to represent a zero amount
	
    //*********************************************************************************************************
    // 	MEMBER DATA --> INSTANCE DATA: EACH INSTANCE OF THE CLASS GETS ONE COPY OF THIS DATA
    //*********************************************************************************************************
    
	
	private int totalAmountInCents;
    
    
    //*********************************************************************************************************
    // 	CTORS 
    //*********************************************************************************************************
   
	
	public DollarAmount(int totalAmountInCents) {		//method tht recieves one-int-param & has no return
    													// same name as class --> CTOR
        this.totalAmountInCents = totalAmountInCents;	// initializes member data
    }

    public DollarAmount(int dollars, int cents) {		// two argument ctor --> receives 2 ints
        this.totalAmountInCents = (dollars * 100) + cents;	// initialize data member w/ values passed
    }
    
    
    
    //*********************************************************************************************************
    // 	MEMBER FUNCTIONS - DATA
    //*********************************************************************************************************
  
    
    //*********************************************************************************************************
    // GETTER METHODS 
    //*********************************************************************************************************
    
    public int getTotalAmountInCents() {
        return this.totalAmountInCents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    
    //*********************************************************************************************************
    // METHODS TO COMPARE OBJECTS OF THE CLASS
    //*********************************************************************************************************
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
    
    //*********************************************************************************************************
    // 	METHOD TO ASK IF THIS VALUE IS NEGATIVE 
    //*********************************************************************************************************
    
    public boolean isNegative() {
        return totalAmountInCents < 0;
    }
    
    //*********************************************************************************************************
    // 	METHODS TO DO SIMPLE ARITHMITIC  
    //*********************************************************************************************************
    
    public DollarAmount minus(DollarAmount amountToSubtract) {
        return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
    }
    
    public DollarAmount plus(DollarAmount amountToAdd) {
        return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
    }
    
    //*********************************************************************************************************
    // 	METHOD USED WITH A JAVA COMPARATOR CLASS 
    //*********************************************************************************************************

    public int compareTo(DollarAmount amountToCompare) {
        if(this.isGreaterThan(amountToCompare)) {
            return 1;		//if 1st if greater than 2nd 
        } else if(this.isLessThan(amountToCompare)) {
            return -1;		//if 1st is less than 2nd
        } else {
            return 0;		// if they are equal
        }
    }
    
    //*********************************************************************************************************
    // 	OBJECT CLASS OVERRIDES SO WE CAN PERFORM JAVA PROCESSING WITH OUR OBJECT
    //*********************************************************************************************************
    
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
