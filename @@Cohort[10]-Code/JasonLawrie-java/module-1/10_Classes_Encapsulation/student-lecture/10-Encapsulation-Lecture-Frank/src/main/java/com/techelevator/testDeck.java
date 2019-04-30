package com.techelevator;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		//aDeck.showDeck();
		aDeck.shuffle();
		//aDeck.showDeck();
		aDeck.howManyDecks();
		CardDeck bDeck = new CardDeck();
		bDeck.howManyDecks();
		
		CardDeck.howManyDecks();
	}
	
	

}
