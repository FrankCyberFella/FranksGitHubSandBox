package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		System.out.println("# of cards in deck: " + aDeck.size());
		aDeck.ShowDeck();
		aDeck.Shuffle();
		aDeck.ShowDeck();
		
		CardDeck aDeck2 = new CardDeck();
		
		aDeck.howManyDecks();
		
		CardDeck aDeck3 = new CardDeck();
		
		aDeck.howManyDecks();
		
	}

}
