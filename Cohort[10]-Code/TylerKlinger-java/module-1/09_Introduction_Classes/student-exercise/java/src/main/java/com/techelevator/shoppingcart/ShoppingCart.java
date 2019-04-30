package com.techelevator.shoppingcart;

public class ShoppingCart {

	//
	// Write code here
	//
	
	
	int totalNumberOfItems;
	double totalAmountOwed;
	
	public double getAveragePricePerItem() {
		
		if ((totalAmountOwed == 0.0) || (totalNumberOfItems == 0.0)) {
			return 0.0;
		}
		return (totalAmountOwed / totalNumberOfItems);
		
		}
	
	public void addItems(int numberOfItems, double pricePerItem ) {
		totalNumberOfItems = numberOfItems + totalNumberOfItems;
		totalAmountOwed = totalAmountOwed + (pricePerItem * numberOfItems);
	}
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
	
	}
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	public void setTotalAmountOwed(double totalAmountOwed) {
		this.totalAmountOwed = totalAmountOwed;
	}
}
