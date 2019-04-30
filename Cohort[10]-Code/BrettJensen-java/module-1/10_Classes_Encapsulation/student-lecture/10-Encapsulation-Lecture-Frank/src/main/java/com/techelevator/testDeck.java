package com.techelevator;

import java.util.Scanner;

public class testDeck {

	public static void main(String[] args) {
		
		CardDeck.howManyDecks();
		
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		System.out.println("# cards in deck: " + aDeck.size());
		
		aDeck.showDeck();
		
		CardDeck aDeck2 = new CardDeck();
		
		aDeck.howManyDecks();

		aDeck.shuffle();
		
		aDeck.showDeck();
		
		
	}

}
