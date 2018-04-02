package CardDeck;

import java.util.*;

import PlayingCard.PlayingCard;

public class CardDeck extends PlayingCard 
{
	LinkedList <PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;

	public CardDeck()
	{
	resetDeck(true);  // reset deck with jokers
	}
	
	public void ShowDeck()
	{
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard c : deckOfCards)
		{ c.ShowCardWithHash(); }
	}
	
	public boolean anyCardsInDeck()
	{ 
		if (deckOfCards.size() > 0)	return true; 
		else                        return false;
	}
	
	public PlayingCard dealCard()
	{ 
		if (deckOfCards.size() > 0)	return deckOfCards.remove(); 
		else
			return null;
	}
	public void resetDeck(boolean withJoker)
	{
		deckOfCards.clear();
		
		for (int i = 1; i < 14; i++) {deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.Club)) ;   }
		for (int i = 1; i < 14; i++) {deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.Heart)) ;  }
		for (int i = 1; i < 14; i++) {deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.Spade)) ;  }
		for (int i = 1; i < 14; i++) {deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.Diamond)) ;}
	
		if (withJoker)
			{
			deckOfCards.add(new PlayingCard(CardValue.Joker, CardSuit.Joker));
			deckOfCards.add(new PlayingCard(CardValue.Joker, CardSuit.Joker));
			}
	}
		
	public void ShuffleDeck()
	{
	resetDeck(false);
    Collections.shuffle(deckOfCards);
	}
	
	public int RemoveJokers()
	{
		ArrayList<PlayingCard> aJoker = new ArrayList();
		aJoker.add(new PlayingCard(CardValue.Joker, CardSuit.Joker));
		int numCardsBefore = deckOfCards.size();
		deckOfCards.removeAll(aJoker);
		return numCardsBefore - deckOfCards.size();
	}
}	