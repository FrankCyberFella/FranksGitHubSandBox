package com.techelevator;

public class KataPotter {

	public static Double cartPrice(int book1, int book2, int book3, int book4, int book5) {
		
		double book1price = 8.00;
		double book2price = 8.00;
		double book3price = 8.00;
		double book4price = 8.00;
		double book5price = 8.00;
		
		double price = book1price + book2price + book3price + book4price + book5price;
		System.out.println(price);
		return price;
	}
}
