package com.techelevator;

public class testDeck {

	public static void main(String[] args) {
		CardDeck aDeck = new CardDeck();  // Instantiate a CardDeck object
		
		CardDeck.howManyDecks();
		
		System.out.println("# cards in deck: " + aDeck.size());
		
		aDeck.showDeck();
		
		aDeck.shuffle();
		
		aDeck.howManyDecks();
		
		aDeck.showDeck();
		
		CardDeck aDeck2 = new CardDeck();  // Instantiate a CardDeck object
		
		aDeck2.howManyDecks();
		
		CardDeck aDeck3 = new CardDeck();
		aDeck.howManyDecks();
		
		System.out.println("# cards in deck: " + aDeck.size());  //need to give class a method so users can
		//do this   size()   in CardDeck   provide behavior for the class, user here in program has no
		// knowledge of how to do it , class needs a method 

		aDeck.shuffle();
		
		aDeck.showDeck();
	}

}





