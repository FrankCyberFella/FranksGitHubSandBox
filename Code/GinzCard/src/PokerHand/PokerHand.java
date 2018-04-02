

package PokerHand;
import java.util.*;

import CardHand.*;
import PlayingCard.*;
import PlayingCard.PlayingCard.CardValue;



public class PokerHand extends CardHand
{
public 	final  int NUMBER_CARDS_IN_HAND = 5;
public  static enum PokerHandRanking {NotRanked,HighCard, Pair, TwoPair, ThreeOfaKind, Straight, Flush, FullHouse, FourOfaKind, StraightFlush, RoyalStraightFlush };

private CardHand aPokerHand;
private PokerHandRanking handRank;
private CardValue rankCard;    // card value from ranking

public CardValue getRankCard() { return rankCard; }

public PokerHand()
{
	aPokerHand = new CardHand(NUMBER_CARDS_IN_HAND);
	handRank   = PokerHandRanking.NotRanked;
}
public void clearHand()
{
	super.emptyHand();
}
public void Show()
{
	super.Show();
}
private boolean hasOnePair()
{
	for (int i = 0; i < NUMBER_CARDS_IN_HAND-1; i++)
	{
		PlayingCard currentCard = new PlayingCard();
	    currentCard = getHand().get(i);
		if (currentCard.getValue() == getHand().get(i+1).getValue())
			{
			rankCard = currentCard.getValue();
			return true;
			}
	}
	return false;
}
private boolean hasTwoPair()
{
	for (int i = 0; i < NUMBER_CARDS_IN_HAND-1; i++)
	{
		PlayingCard currentCard = new PlayingCard();
	    currentCard = getHand().get(i);
		if ((currentCard.getValue() == getHand().get(i+1).getValue()))
			{
			for (int j = i+2; j < NUMBER_CARDS_IN_HAND - 1; j++)
			  {
				currentCard = getHand().get(j);
				if ((currentCard.getValue() == getHand().get(j+1).getValue()))	return true;
			  }
			}
	}
	return false;
}
private boolean hasThreeOfaKind()
{
	for (int i = 0; i < NUMBER_CARDS_IN_HAND-2; i++)
	{
		PlayingCard currentCard = new PlayingCard();
	    currentCard = getHand().get(i);
		if  ((currentCard.getValue() == getHand().get(i+1).getValue())
		  && (currentCard.getValue() == getHand().get(i+2).getValue())) return true;
	}
	return false;
}
private boolean hasFourOfaKind()
{
	for (int i = 0; i < NUMBER_CARDS_IN_HAND-3; i++)
	{
		PlayingCard currentCard = new PlayingCard();
	    currentCard = getHand().get(i);
		if  ((currentCard.getValue() == getHand().get(i+1).getValue())
		  && (currentCard.getValue() == getHand().get(i+2).getValue())		
		  && (currentCard.getValue() == getHand().get(i+3).getValue())) return true;
	}
	return false;
}
private boolean hasFlush()
{
	if  ((getHand().get(0).getSuit() == getHand().get(1).getSuit())
	  && (getHand().get(0).getSuit() == getHand().get(2).getSuit())	
	  && (getHand().get(0).getSuit() == getHand().get(3).getSuit())
	  && (getHand().get(0).getSuit() == getHand().get(4).getSuit())) return true;
	else
	   return false;
}
public PokerHandRanking rankHand()
{
	this.SortByValue();
	if(handRank == null)   handRank = PokerHandRanking.NotRanked;
	if(hasOnePair())       handRank = PokerHandRanking.Pair;
	if(hasTwoPair())       handRank = PokerHandRanking.TwoPair;
	if(hasThreeOfaKind())  handRank = PokerHandRanking.ThreeOfaKind;
	if(hasFourOfaKind())   handRank = PokerHandRanking.FourOfaKind;
//	if(hasOnePair() 
//    && hasThreeOfaKind())  handRank = PokerHandRanking.FullHouse;
//	if(hasStraight())      handRank = PokerHandRanking.Straight;
	
//	this.SortBySuit();
	if(hasFlush())         handRank = PokerHandRanking.Flush;

	
	
    return handRank;
	

}
}
