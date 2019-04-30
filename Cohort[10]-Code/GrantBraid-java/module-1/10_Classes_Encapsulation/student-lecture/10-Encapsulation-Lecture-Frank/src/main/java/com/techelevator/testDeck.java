package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks(); // what if we dont have any decks yet
		
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck.howManyDecks();
		
		//aDeck.ShowDeck();
		
		//System.out.println("# cards in deck: " + aDeck.size());
		
		//aDeck.shuffle();
		
		//System.out.println("Shuffled deck:\n");
		//aDeck.ShowDeck();

		
		CardDeck aDeck2 = new CardDeck(); // Instantiate a CardDeck object
		
		aDeck.howManyDecks();
		
		CardDeck aDeck3 = new CardDeck(); // Instantiate a CardDeck object
		
		aDeck.howManyDecks();
		
		


		
	}

}
