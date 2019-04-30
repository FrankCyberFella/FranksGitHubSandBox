package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class CardDeck {
	private static int totalNumOfDecks = 0;
	//class variable -- only one regardless of the number of objects, so everyone shares this
	//instance variable - one copy for each instance of an object
	
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	public CardDeck() { // Default Constructor - instantiate a standard deck with no jokers
		for (int value = 1; value <= 13; value++) { //loop through all the values
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) { // loop through the suits
				deck.add(new PlayingCard(suit, value)); // add the suits with their values to the list deck
			}
		}	
		totalNumOfDecks++;
	}
	public static void howManyDecks() { //static method allows the method to run without an object
										// allows classname to be used to run the method
		System.out.println("Total number of decks is: " + totalNumOfDecks);
	}
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n"); //tallies up the deck size and prints it feat. escape character
		for(PlayingCard aCard : deck) {	
			aCard.toString();// escape characters need \char
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


