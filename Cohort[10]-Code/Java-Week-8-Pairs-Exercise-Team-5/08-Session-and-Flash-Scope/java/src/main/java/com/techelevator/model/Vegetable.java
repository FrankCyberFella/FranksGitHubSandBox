package com.techelevator.model;

public class Vegetable {

	private String type;
	private double itemPrice;
	private int quantity;
	
	
	public Vegetable(String type, int quantity, double itemPrice) {
		this.type = type;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the name
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	


	


	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}


	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
