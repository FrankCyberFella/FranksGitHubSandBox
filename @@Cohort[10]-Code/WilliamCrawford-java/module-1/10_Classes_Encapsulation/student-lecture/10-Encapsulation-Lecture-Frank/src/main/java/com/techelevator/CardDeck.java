package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	public static int numberOfDecks = 0;//class variable
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	public CardDeck() {      //default-constructor(ctor), no arguments, no return type,- same name as class: instantiates a standard deck with no jokers
		for (int value = 1; value <= 13; value++) {
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {//creates new playing card 52 xs
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
		for(PlayingCard aCard : deck) {    //creates suits for each playing card
			System.out.println(aCard);
		}
		
	
	}

	
}


