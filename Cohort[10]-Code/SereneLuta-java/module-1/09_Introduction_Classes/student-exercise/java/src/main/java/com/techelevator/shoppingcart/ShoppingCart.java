package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
	public double getAveragePricePerItem() {
		if(totalNumberOfItems == 0) {
			return 0;
		}
		return totalAmountOwed / totalNumberOfItems;
		
	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		this.totalNumberOfItems = numberOfItems + totalNumberOfItems;
		this.totalAmountOwed  += pricePerItem * numberOfItems;
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
	
	public void empty() {
		this.totalNumberOfItems = 0;
		this.totalAmountOwed = 0.0;
	}
}

	

