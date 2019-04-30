package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	
	//class variables - only one, regardless of the number of objects, all objects share the one copy
	private static int numberOfDecks = 0;
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	public CardDeck() { // Default constructor - instantiate a standard deck with no Jokers
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}	
		
		numberOfDecks++;
	}
	
	public void howManyDecks() {
		System.out.println("# of Decks: " + numberOfDecks);
	}
	
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}

	public int size() {
		return deck.size();
	}
	
}


