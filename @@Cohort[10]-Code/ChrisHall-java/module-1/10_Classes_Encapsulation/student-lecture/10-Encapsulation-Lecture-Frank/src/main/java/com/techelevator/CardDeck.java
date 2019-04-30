package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class variable-- only one copy (for Class), regardless of the number of objects created.  Common counting strategy. 
// Compare this instance variables.



public class CardDeck { 
	//instance variable means one copy per instance of object
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	private static int numberOfDecks = 0;  ////  ********	
	
	//methods
	
	//ctor
	public CardDeck() {
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
				
			}
			
		} numberOfDecks++; // count new decks...need this  concept for exercises.
		
	}
	public static void howManyDecks() {  // static method allows the method to run without an object
		// allows the class name to be used to run the method.
		System.out.println(" # of Decks is: " + numberOfDecks);
	}
	//above just all keeps track of how many decks there are
	
	
	public void showDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}

	public int size () {
		return deck.size();
	}



public void shuffle() {
	Collections.shuffle(deck);
}
	
}