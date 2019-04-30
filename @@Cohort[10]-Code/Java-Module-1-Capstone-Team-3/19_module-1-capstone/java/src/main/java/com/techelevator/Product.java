package com.techelevator;

public class Product {
	
	private String name = "";
	private double price = 0.00;
	private String type = "";
	
	public Product (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the type
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

	@Override
	public String toString() {
		
		return this.getName() + " " + this.getPrice() + " " + this.getType();
	}

}
