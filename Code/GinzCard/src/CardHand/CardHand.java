package CardHand;

import java.util.*;

import PlayingCard.PlayingCard;
import CardDeck.CardDeck;

public class CardHand 
{
	
	int numCardsInHand;
	private ArrayList<PlayingCard> aHand; 
	
	
	public CardHand()	
	{	numCardsInHand = 5;
		aHand = new ArrayList<PlayingCard>(numCardsInHand);
	}
	
	public CardHand(int numCards)	
	{	numCardsInHand = numCards;
		aHand = new ArrayList<PlayingCard>(numCardsInHand);
	}
	public ArrayList<PlayingCard> getHand() { return aHand; }
	
	public void addCard(PlayingCard aCard)
	{
		aHand.add(aCard);
	}
	public void emptyHand()
	{
		aHand.clear();
	}
	public void Show()
	{
		for (PlayingCard aCard : aHand)  System.out.println(aCard);
	}
	
	
	public void SortByValue()
	{
		Collections.sort(aHand, new ValueSort());
	}
	public void SortByColor()
	{
		Collections.sort(aHand, new ColorSort());
	}
	public void SortBySuit()
	{
		Collections.sort(aHand, new SuitSort());
	}
	
	public class ValueSort implements Comparator<PlayingCard>
	{
		public int compare(PlayingCard Card1, PlayingCard Card2)
		{
			return Card1.getintValue() - Card2.getintValue();
		}
	}
	public class SuitSort implements Comparator<PlayingCard>
	{
		public int compare(PlayingCard Card1, PlayingCard Card2)
		{				
			return Card1.getSuit().ordinal() - Card2.getSuit().ordinal();
		}
	}

	public class ColorSort implements Comparator<PlayingCard>
	{
		public int compare(PlayingCard Card1, PlayingCard Card2)
		{	
			return Card1.getColor().ordinal()- Card2.getColor().ordinal();
		}
	}
}
