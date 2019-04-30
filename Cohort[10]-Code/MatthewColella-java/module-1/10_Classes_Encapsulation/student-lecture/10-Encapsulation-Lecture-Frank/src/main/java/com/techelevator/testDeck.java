package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.ShowDeck();
		
		aDeck.shuffle();
		
		System.out.println("number of cards in deck: " + aDeck.size());
		
		
		CardDeck aDeck2 = new CardDeck();
		aDeck2.howManyDecks();
		aDeck.howManyDecks();
		
	}

}
