package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		//aDeck.ShowDeck();
		
		System.out.println("# of cards in deck: " + aDeck.size());
		
		CardDeck aDeck2 = new CardDeck(); 
		
		CardDeck aDeck3 = new CardDeck(); 

		aDeck.shuffle();
		
		aDeck.ShowDeck();
		
		aDeck.howManyDecks();
	}

}
