package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	// class variables - only one regardless of the number of objects ( all objects share one copy)
	private static int numberOfDecks = 0;
	
	// instance variables - one copy for each instance of an object
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();

	
	public CardDeck() {		// Default constructor - standard deck with no joker
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}
		numberOfDecks++;
	}

	
	// static method allows the method to run without an object
	// allows the className to be used to run method ( CardDeck.howManyDecks())
	public static void howManyDecks() {
		System.out.println("# of decks is: " + numberOfDecks);
	}

	public void showDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
			System.out.println("----------------");
		}
	}
	
	
	public int size() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

	
}


