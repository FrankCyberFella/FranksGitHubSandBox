package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		aDeck.howManyDecks();
		
		System.out.println("# cards in deck: " + aDeck.size());
		
	aDeck.ShowDeck();
	
	aDeck.Shuffle();
	
	aDeck.ShowDeck();
	
	CardDeck aDeck2 = new CardDeck (); // Instantiate a CardDeck object
	
	aDeck.howManyDecks();
	
	CardDeck aDeck3 = new CardDeck(); // Instantaite a CardDeck object
	aDeck.howManyDecks();

	}
}
