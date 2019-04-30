package com.techelevator3;

public class Book {

	private String title;
	private int pageNumbers;
	private double price;
	private String author;
	private static double totalCheckoutPrice = 0.0;
	private static int totalNumberOfBooks = 0;
	
	
	
	/**
	 * @return the pageNumbers
	 */
	public int getPageNumbers() {
		return pageNumbers;
	}



	/**
	 * @param pageNumbers the pageNumbers to set
	 */
	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}



	public Book(String title, double price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	public void purchase() {
		String bookBuy = title + " " + author;
		System.out.println(bookBuy);
		System.out.println(price);
		totalCheckoutPrice += price;
		totalNumberOfBooks++;
	}
	
	public void checkout() {
		System.out.println("Youve purchased " + totalNumberOfBooks + " Books");
		System.out.println("Total price: " + totalCheckoutPrice);
	}

}
