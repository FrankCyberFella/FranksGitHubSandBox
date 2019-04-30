package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {// default constructor
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	int numberOfDecks = 0;
	
	public CardDeck() {
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {
				deck.add(new PlayingCard(suit, value));
			}
		}
		numberOfDecks++; //count the new deck
		
	}
	public static void howManyDecks() { // static method allows the method to run without an object
		// allows the class name to be used to run the method
		System.out.println ("# of Decks is :" + numberOfDecks);
	}
	
	//method to display the values in a PlayingCard
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		}
	}
	public int size() {
		return deck.size();
	}
public void Shuffle() {
	Collections.shuffle(deck);
}
	
}


