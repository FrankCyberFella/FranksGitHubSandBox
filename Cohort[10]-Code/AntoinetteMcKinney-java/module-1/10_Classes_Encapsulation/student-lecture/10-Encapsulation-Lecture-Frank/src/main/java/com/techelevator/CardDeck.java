package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	

// class variables - only one regarldess of the number of objects
// all objects share the one copy

	private static int numberOfDecks = 0;


	// INSTANCE VARIABLES - ONE COPY FO EACH INSTANCE OF AN OBJECT 
	
	private List<PlayingCard> deck = new ArrayList<PlayingCard>();
	
	
	// methods
	
	public CardDeck() { // the name is the same as class of the class tells you its a constructor. Default Constructor bec () instantiate a standared deck with no jokers
		for (int value = 1; value <= 13; value++) { // this is a loop with value will be the card value.
			for (String suit : new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}) {// for each loop . go through one time each time refer to suit. 
				deck.add(new PlayingCard(suit, value));
			}
		}	
		numberOfDecks++; //Count the new deck 
	}
	public static  void  howManyDecks () { // static method allows the method to run without an object
										   // allows the classname to be sed to run method
		System.out.println(" # of Decks is: " + numberOfDecks);
	}
	
	public void ShowDeck() {
		System.out.println("Number of cards in deck: " + deck.size() + "\n");
		for(PlayingCard aCard : deck) {
			System.out.println(aCard);
		
			
		}
	}
	public int size() {
			return deck.size ();	
	}
	public void Shuffle()
	Collections.shuffle(deck);// invoke the Collection class shuffle method which randoms the data in a Collection Collections. 	{
		Collections.shuffle(deck);
	
	}
}


