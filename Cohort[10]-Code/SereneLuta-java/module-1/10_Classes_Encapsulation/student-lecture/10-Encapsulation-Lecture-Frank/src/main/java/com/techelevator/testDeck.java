package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.howManyDecks();
		
		System.out.println("# of cards in a deck: " + aDeck.size());
		
//		aDeck.showDeck();
		
//		aDeck.shuffle();
		
		CardDeck aDeck2 = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.howManyDecks();

		
		CardDeck aDeck3 = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.howManyDecks();

		
	}

}
