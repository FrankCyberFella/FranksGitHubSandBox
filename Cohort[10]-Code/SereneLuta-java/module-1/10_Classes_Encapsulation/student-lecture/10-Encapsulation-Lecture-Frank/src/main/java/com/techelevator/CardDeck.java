package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	// class variables - one one regardless of the number of objects
	//                   all objects share the one copy
	private static int numberOfDecks = 0;

	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	//instance variables - one copy for each instance of an object
//	private static int numberOfDecks = 0;
	
	public CardDeck() { // Default constructor: Same name as the class with no parameters. No return type is a part of all constructors
		// Loop will instantiate a standard deck with no jokers
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) { // declares the String array in the loop b/c we don't need to variable outside of the loop. Clean code.
				deck.add(new PlayingCard(suit, value)); // don't name the String array if you do it this way
			}
		}
		numberOfDecks++; // Count the new deck. Do this within the constructor.
	}
	
	
	public static void howManyDecks() { // static method allows the method to run without an object
										// allows the classname to be used to run the method
		System.out.println("# of Decks is: " + numberOfDecks);
	}
	
	
	public void showDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
		
		System.out.println("PlayingCard equals method is running");

	
		}
		public int size() {
			return deck.size();
	}
		
		public void shuffle() {
			Collections.shuffle(deck); // invokes the Collections class shuffle method which randomly moves the data in a Collection
		}

	
}


