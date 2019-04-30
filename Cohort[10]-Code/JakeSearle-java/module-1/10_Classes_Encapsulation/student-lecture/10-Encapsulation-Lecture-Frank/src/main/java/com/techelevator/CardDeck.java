package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	
	private static int numberOfDecks = 0; // class variable - only one regardless of number of objects, and all objects share one copy.
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();

	
	public CardDeck() {
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}	
		numberOfDecks++;       // count the new deck
	}
	public static void howManyDecks() {         // static method allows method to run without an object
												// allows class name to run the method
		System.out.println("# of decks is: " + numberOfDecks);
	}
	
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}
}


