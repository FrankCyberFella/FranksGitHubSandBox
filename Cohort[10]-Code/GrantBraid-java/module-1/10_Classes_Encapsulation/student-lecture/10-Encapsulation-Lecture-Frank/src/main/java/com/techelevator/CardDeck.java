package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	//class variables - only one regardless of the number of objects
	// all objects share the one copy
	
	
	private static int numberOfDecks = 0; 
	
	
	//instance variable - one copy for each instance of an object
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();

	
	public CardDeck() { // Default ctor - instantiate a standard deck with no jokers
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}
		numberOfDecks++; // Count the new deck
	}
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}
	
	public static void howManyDecks() { // static method allows method to run without an object	
		System.out.println("# of Decks is: " + numberOfDecks);
	}
	
	public int size() {
		return deck.size();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
	
}


