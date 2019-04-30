package com.techelevator3;

public class ComicBook extends Book {

	private int edition;
	private boolean isWrapped;
	
	
	
	/**
	 * @return the edition
	 */
	public int getEdition() {
		return edition;
	}

	/**
	 * @return the isWrapped
	 */
	public boolean isWrapped() {
		return isWrapped;
	}

	public ComicBook(String title, double price, String author, boolean isWrapped, int edition) {
		super(title,price,author);
		this.isWrapped = isWrapped;
		this.edition = edition;
		
		
	}
	
	@Override
	public void purchase() {
		double test = 0.0;
		if(isWrapped == true && edition < 3) {
			test = super.getPrice() * 2;
			super.setPrice(test);
		}
		super.purchase();
	}
	
	
	
}
