package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Item {
	//'                                         ________  h___
	//'  __        __      _____       ___     |        | |  L|_
	//'_/ L\__   _| L\__  |    L\_   _/  L\__  |        |_|     |
	//'-o---o-' '-o---o-' '-O---O-' '=o----o-' '-OO----`OO----O-'
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	//	    Declare dataMembers
	private String name;
	private String type;
	private double price;
	public static Map<String, String> consumedMap = new HashMap<String, String>();
	
	
	//'                                         ________  h___
	//'  __        __      _____       ___     |        | |  L|_
	//'_/ L\__   _| L\__  |    L\_   _/  L\__  |        |_|     |
	//'-o---o-' '-o---o-' '-O---O-' '=o----o-' '-OO----`OO----O-'
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	//	    Constructors
	public Item(String name, String type, double price) {
		this.name=name;
		this.type=type;
		this.price=price;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	
}
