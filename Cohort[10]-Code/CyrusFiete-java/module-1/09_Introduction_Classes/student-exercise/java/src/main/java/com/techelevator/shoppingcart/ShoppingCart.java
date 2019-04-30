package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
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

//methods

public double getAveragePricePerItem() {
	if (totalNumberOfItems == 0 && totalAmountOwed == 0.0) {
		return 0.0;
	}
	else {
	return totalAmountOwed/totalNumberOfItems;
	}
}
public void addItems(int numberOfItems, double pricePerItem) {
	totalNumberOfItems += numberOfItems;
	totalAmountOwed += pricePerItem*numberOfItems;
}
public void empty() {
	totalNumberOfItems = 0;
	totalAmountOwed = 0.0;
}
	
}
