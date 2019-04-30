package com.techelevator;

import java.util.Collections;

public class testDeck {

	public static void main(String[] args) {
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		System.out.println("# cards in deck: " + aDeck.size());
	
		aDeck.ShowDeck();
		
		aDeck.Shuffle()
		}

}
