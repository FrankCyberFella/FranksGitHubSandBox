package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	// instance variables - one copy for each instance of an object
	
	private static int numberOfDecks = 0;
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	public CardDeck() { //Default ctor (no return type, no parameters) 
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}	
		numberOfDecks++;
	}
	
	public static void howManyDecks() {
		System.out.println("# of Decks is: " + numberOfDecks);
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
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	

	
}


