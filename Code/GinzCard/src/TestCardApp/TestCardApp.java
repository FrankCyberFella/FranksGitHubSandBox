package TestCardApp;

import CardDeck.CardDeck;
import PlayingCard.PlayingCard;
import CardHand.CardHand;
import PokerHand.*;
import PokerHand.PokerHand.PokerHandRanking;

public class TestCardApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CardDeck  myDeck = new CardDeck();
		CardHand  myHand = new CardHand();
		PokerHand myPokerHand = new PokerHand();
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Showing Cards in Deck                           --");
		System.out.println("-----------------------------------------------------");
		
		myDeck.ShowDeck();
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Removing Jokers from Deck                       --");
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Number Jokers Removed: " + myDeck.RemoveJokers());
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Shuffling Deck                                  --");
		System.out.println("-----------------------------------------------------");
		
	    myDeck.ShuffleDeck();
		myDeck.ShowDeck();
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Dealing Cards from Deck                         --");
		System.out.println("-----------------------------------------------------");
		
		while(myDeck.anyCardsInDeck())
		System.out.println(myDeck.dealCard().toString());

	System.out.println("-----------------------------------------------------");
	System.out.println("-- Dealing Cards to a PokerHand                          --");
	System.out.println("-----------------------------------------------------");
 
	myDeck.ShuffleDeck();
	
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	
	myPokerHand.Show();
	/*
	System.out.println("-----------------------------------------------------");
	System.out.println("-- Sorting PokerHand by Value                           --");
	System.out.println("-----------------------------------------------------");
	
	myPokerHand.SortByValue();
	myPokerHand.Show();
	
	System.out.println("-----------------------------------------------------");
	System.out.println("-- Sorting PokerHand by Color                           --");
	System.out.println("-----------------------------------------------------");
	
	myPokerHand.SortByColor();
	myPokerHand.Show();
	
	System.out.println("-----------------------------------------------------");
	System.out.println("-- Sorting PokerHand by Suit                           --");
	System.out.println("-----------------------------------------------------");
	
	myPokerHand.SortBySuit();
	myPokerHand.Show();
*/	
	System.out.println("-----------------------------------------------------");
	System.out.println("-- Ranking PokerHand                                    --");
	System.out.println("-----------------------------------------------------");
	
	boolean done = false;
	int numDeals = 0;
	while(!done)
	{
	numDeals++;
	myPokerHand.clearHand();
    myDeck.resetDeck(false);
    myDeck.ShuffleDeck();
	
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	myPokerHand.addCard(myDeck.dealCard());
	
	
	if (myPokerHand.rankHand() == PokerHandRanking.FullHouse) 
		{
		System.out.println(myPokerHand.rankHand());
		myPokerHand.Show();
		done=true;
		}
	}
	System.out.println("Number of Deals: " + numDeals);
	}
}
