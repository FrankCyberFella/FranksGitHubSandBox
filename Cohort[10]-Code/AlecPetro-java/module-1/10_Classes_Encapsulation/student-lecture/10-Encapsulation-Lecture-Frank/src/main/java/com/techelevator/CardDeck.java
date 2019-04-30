package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	
	//class vairables - only one regardless of the number of objects
	// all objects share the one copy
	
	private static int numberOfDecks = 0;
	
	// instance variable - one copy for each instance of an object
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>(); // deck is an instance variable
	
	
	
	
	//methods
	
	public CardDeck() { // default ctor - instantiate a standard deck with no jokers
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) { // inner loop runs through its entirety before value goes to 2
				deck.add(new PlayingCard(suit, value));
			}
		}	
		numberOfDecks++; // Count the new Deck
	}
	public static void howManyDecks() { // static method allows the method to run without an object
										// allows the class name to be used to run the method
		System.out.println("# of decks is: " + numberOfDecks);
	}
	
	public void showDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}

	public int size() {
		return deck.size();
	}
	public void shuffle() {
		Collections.shuffle(deck); // invoke the Collection class shuffle method which randoms the date in a Collection
	}
	
}


