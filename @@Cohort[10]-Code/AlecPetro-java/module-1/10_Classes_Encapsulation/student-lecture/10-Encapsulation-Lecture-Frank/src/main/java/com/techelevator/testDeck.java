package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.howManyDecks();
		
		System.out.println("# cards in deck: " + aDeck.size());
		
		CardDeck aDeck1 = new CardDeck();
		
		aDeck.howManyDecks();
		
		aDeck.shuffle();

		aDeck.showDeck();
	}

}
