package com.techelevator;

public class PlayingCard {
// define the data members of the class
<<<<<<< HEAD
private String 	suit;
private String 	color;
private int 	value;
private String	image;
private String	shape;

//define methods for the class

//default constructor - assign default values to data of the class
=======
private String suit;
private String color;
private int    value;
private String image;
private String shape;

// define methods for the class

// default constructor - assign default values to data of the class
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf

public PlayingCard() {
	suit = "Joker";
	color = "red";
	value = 0;
	image = "jester";
	shape = "rectangle";
}

// ctor for a card for only a suit, value
public PlayingCard(String suit, int value) {
// the keyword "this" indicates a member in the object being processed
	this.suit = suit;
<<<<<<< HEAD
	if(suit.equals("CLUBS") || suit.equals("SPADES")){
				color = "BLACK";
	} 
	else {
		if(suit.equals("HEARTS") || suit.equals("DIAMONDS")){
				color = "RED";
	}
		else {
				color = "unknown";
		}
	}
=======
	determineColor(suit);
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
	this.value = value;
	image = value + " " + suit;
	shape = "rectangle";
}
<<<<<<< HEAD
//ctor to create card with suit, value, image, shape
=======


// ctor to create card with suit, value, image, shape
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public PlayingCard(String suit, int value, String image, String shape) {
	this.suit = suit;
	determineColor(suit);
	this.value = value;
	this.image = image;
	this.shape = shape;
<<<<<<< HEAD
}

=======
}	
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf


// method to determine card color based on the suit
// restrict usage to members of class - don't want class users to be able to be to run this

/**
 * @return the suit
 */
public String getSuit() {
	return suit;
}

/**
 * @param suit the suit to set
 */
public void setSuit(String suit) {
	this.suit = suit;
}

/**
 * @return the value
 */
public int getValue() {
	return value;
}
public String getValueName() {
<<<<<<< HEAD
	switch (value) { // check the value in the variable specified
	case 1:				// if the value is this....
		return "ACE";	//....do this
	case 2:
		return "TWO";
	case 3:
		return "THREE";
	case 4:
		return "FOUR";
	case 5:
		return "FIVE";
	case 6:
		return "SIX";
	case 7:
		return "SEVEN";
	case 8:
		return "EIGHT";
	case 9:
		return "NINE";
	case 10:
		return "TEN";
	case 11:
		return "JACK";
	case 12:
		return "QUEEN";
	case 13:
		return "KING";
	}
	return "unknown";
}

=======
	switch (value) {  // check the value in the variable give
	case 1:           // if the value is this...
		return "Ace"; // do this
	case 2:
		return "Two";
	case 3:
		return "Three";	
	case 4:
		return "Four";
	case 5:
		return "Five";
	case 6:
		return "Six";
	case 7:
		return "Seven";
	case 8:
		return "Eight";
	case 9:
		return "Nine";
	case 10:
		return "Ten";
	case 11:
		return "Jack";
	case 12:
		return "Queen";
	case 13:
		return "King";
	}
	return "unknown";
}
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
/**
 * @param value the value to set
 */
public void setValue(int value) {
	this.value = value;
}

/**
 * @return the image
 */
public String getImage() {
	return image;
}

/**
 * @param image the image to set
 */
public void setImage(String image) {
	this.image = image;
}

/**
 * @return the shape
 */
public String getShape() {
	return shape;
}

/**
 * @param shape the shape to set
 */
public void setShape(String shape) {
	this.shape = shape;
}

/**
 * @return the color
 */
public String getColor() {
	return color;
}

private void determineColor(String suit) {
<<<<<<< HEAD
	if(suit.equals("CLUBS") || suit.equals("SPADES")){
		color = "BLACK";
		} 
		else {
			if(suit.equals("HEARTS") || suit.equals("DIAMONDS")){
		color = "RED";
			}
		else {
		color = "unknown";
		}
		}
	}

// method to display the values in a PlayingCard
public void showCard() {
	System.out.println("Card suit: " + suit);
=======
	
	if (suit.equals("Clubs") || suit.equals("Spades")) {
		 color = "black";
	}
	else {
		if (suit.equals("Hearts") || suit.equals("Diamonds")) {
			color = "red";
		}
		else {
			color = "unknown";
		}
	}
}


// method to display the values in a PlayingCard
public void showCard() {
	System.out.println("Card  suit: " + suit);
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
	System.out.println("Card color: " + color);
	System.out.println("Card value: " + value);
	System.out.println("Card image: " + image);
	System.out.println("Card shape: " + shape);
}
}
