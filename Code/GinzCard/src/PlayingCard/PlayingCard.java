package PlayingCard;
import java.util.*;

public class PlayingCard 
{
public    static       enum CardColor { Black, Red };
public    static       enum CardSuit  { Spade, Club, Heart, Diamond, Joker };
public    static       enum CardValue { Joker, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
	
protected static final CardValue  DEFAULT_CARD_VALUE  = CardValue.Joker;
protected static final CardColor  DEFAULT_COLOR       = CardColor.Black;
protected static final CardSuit   DEFAULT_SUIT        = CardSuit.Joker;
	
protected CardValue value;
protected CardColor color;
protected CardSuit  suit;

public PlayingCard() // throws InvalidCardValueException
{
	value = DEFAULT_CARD_VALUE;	
	suit  = DEFAULT_SUIT;
	setColor(suit);
} // End of PlayingCard()

public PlayingCard(CardValue value, CardSuit suit)
{
	this.value = value;
	setColor(suit);
	this.suit  = suit;
} 
public PlayingCard(int value, CardSuit suit)
{
	this.value = setValue(value);
	setColor(suit);
	this.suit  = suit;
} 

public CardValue getValue() { return value; }
public int getintValue()    { return value.ordinal(); }

public CardValue setValue(int ivalue)
{
	switch (ivalue)
	{
	case  1: return CardValue.One;
	case  2: return CardValue.Two;
	case  3: return CardValue.Three;
	case  4: return CardValue.Four;
	case  5: return CardValue.Five;
	case  6: return CardValue.Six;
	case  7: return CardValue.Seven;
	case  8: return CardValue.Eight;
	case  9: return CardValue.Nine;
	case 10: return CardValue.Ten;
	case 11: return CardValue.Jack;
	case 12: return CardValue.Queen;
	case 13: return CardValue.King;
	default: return CardValue.Joker;
	
	
	
	}
}

public CardColor getColor() { 	return color; }

private void setColor(CardSuit suit) 
{ 
	switch (suit)
	{
	case Spade:
	case Club:
	  this.color = CardColor.Black;
	  break;
	case Diamond:
	case Heart:
		this.color = CardColor.Red;
		break;
	default:
		this.color = DEFAULT_COLOR;
	}
}

public CardSuit getSuit() { return suit; }

public void setSuit(CardSuit suit) { this.suit = suit; }

public String toString()
{
StringBuffer stringCard = new StringBuffer();

int firstColumnSize = 16;

stringCard.append("Value: " + value);
stringCard.append(" (" + getintValue() + ")");
if (stringCard.length() < firstColumnSize) stringCard.append("\t");
stringCard.append("\tSuit: "  + suit );
stringCard.append("\tColor: " + color); 
return stringCard.toString();
}

public void ShowCard() { System.out.println(this.toString()); }

public void ShowCardWithHash() { System.out.println(this.toString() + "\thashCode: " + hashCode()); }

public boolean equals(Object otherObject)
{
	boolean areEqual = false;
	
	if (otherObject == this) areEqual = true;
	
	if ((otherObject instanceof PlayingCard))
			{
		    PlayingCard otherCard = (PlayingCard) otherObject;
		    if  (  this.value == otherCard.value
		    	&& this.color == otherCard.color
		    	&& this.suit  == otherCard.suit) areEqual = true;
			}
	return areEqual;
}

public int hashCode()
{
	int hashValue = 17;
	int primeMultipler = 59;
	
	hashValue = hashValue * primeMultipler + value.ordinal();
	hashValue = hashValue * primeMultipler + suit.ordinal();
	hashValue = hashValue * primeMultipler + color.ordinal();
	
	return hashValue;
}



} // End of Class PlayingCard
