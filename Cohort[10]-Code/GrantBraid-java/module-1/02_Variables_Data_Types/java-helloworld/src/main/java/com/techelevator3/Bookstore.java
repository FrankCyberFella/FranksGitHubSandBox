package com.techelevator3;

public class Bookstore {

	public static void main(String[] args) {
		
		
		Book nameOfTheWind = new Book("Name Of The Wind", 21.99, "Patrick Rothless");
		Book nameOfTheWind2 = new Book("Name Of The Wind", 25.99, "Patrick Rothless");
		Book comicBook = new ComicBook("Spiderman" , 5.00, "Stan Lee", false, 2);
		
		
		nameOfTheWind.purchase();
		nameOfTheWind2.purchase();
		comicBook.purchase();
		nameOfTheWind.checkout();
	}
	
}
