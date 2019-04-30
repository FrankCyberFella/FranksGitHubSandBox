package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String name;
	private double price;
	private String imgLoc;
	
	public Product() {
		
	}

	public Product(String name, double price, String imgLoc) {
		this.name=name;
		this.price=price;
		this.imgLoc=imgLoc;
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
	 * @return the imgLoc
	 */
	public String getImgLoc() {
		return imgLoc;
	}

	/**
	 * @param imgLoc the imgLoc to set
	 */
	public void setImgLoc(String imgLoc) {
		this.imgLoc = imgLoc;
	}
	
	public static List<Product> listAll(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Bell Peppers",5.99,"img/peppers.jpg"));
		products.add(new Product("Carrots",2.99,"img/carrots.jpg"));
		products.add(new Product("Cucumbers",3.99,"img/cucumbers.jpg"));
		products.add(new Product("Heirloom Tomatoes",4.99,"img/tomatoes.jpg"));
		products.add(new Product("Radishes",11.99,"img/radishes.jpg"));
		
		
		return products;
	}
}
