package com.techelevator;

public class PlayingCard {
<<<<<<< HEAD

//define the data members of the class
	
	private String suit;
	private String color;
	private int value;
	private String image;
	private String shape;
	
//define methods for the class
//default constructor - assign default values to the data of the class
	
public PlayingCard() {
	
	suit = "joker";
	value = 0;
	color = "red";
	image = "jester";
	shape = "rectangle";
	
}

//ctor for a card for only a suit, value

public PlayingCard(String suit, Integer value) {
	
//the keyword 'this' indicates a member in the object being processed
	
	this.suit = suit;
	this.value = value;
	determineColor(suit);
	image = value + " of " + suit;
	shape = "rectangle";
	
}

//ctor to create card with suit, value, image, shape

public PlayingCard(String suit, Integer value, String image, String shape) {
	
	this.suit = suit.toLowerCase();
	this.value = value;
	determineColor(suit);
	this.image = image;
	this.shape = shape;
	
}

=======
// define the data members of the class
private String suit;
private String color;
private int    value;
private String image;
private String shape;

// define methods for the class

// default constructor - assign default values to data of the class

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
	determineColor(suit);
	this.value = value;
	image = value + " " + suit;
	shape = "rectangle";
}


// ctor to create card with suit, value, image, shape
public PlayingCard(String suit, int value, String image, String shape) {
	this.suit = suit;
	determineColor(suit);
	this.value = value;
	this.image = image;
	this.shape = shape;
}	


// method to determine card color based on the suit
// restrict usage to members of class - don't want class users to be able to be to run this

/**
 * @return the suit
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public String getSuit() {
	return suit;
}

<<<<<<< HEAD
=======
/**
 * @param suit the suit to set
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public void setSuit(String suit) {
	this.suit = suit;
}

<<<<<<< HEAD
public int getValue() {
	return value;
}

public String getValueName() {
	switch (value) { //check the value in the variable
	case 1:			 //if the value is this... do that >
		return "ace";
	case 2:
		return "two";
	case 3:
		return "three";
	case 4:
		return "four";
	case 5:
		return "five";
	case 6:
		return "six";
	case 7:
		return "seven";
	case 8:
		return "eight";
	case 9:
		return "nine";
	case 10:
		return "ten";
	case 11:
		return "jack";
	case 12:
		return "queen";
	case 13:
		return "king";
	}
	return "unknown";
}

=======
/**
 * @return the value
 */
public int getValue() {
	return value;
}
public String getValueName() {
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
/**
 * @param value the value to set
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public void setValue(int value) {
	this.value = value;
}

<<<<<<< HEAD
=======
/**
 * @return the image
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public String getImage() {
	return image;
}

<<<<<<< HEAD
=======
/**
 * @param image the image to set
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public void setImage(String image) {
	this.image = image;
}

<<<<<<< HEAD
=======
/**
 * @return the shape
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public String getShape() {
	return shape;
}

<<<<<<< HEAD
=======
/**
 * @param shape the shape to set
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public void setShape(String shape) {
	this.shape = shape;
}

<<<<<<< HEAD
=======
/**
 * @return the color
 */
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public String getColor() {
	return color;
}

<<<<<<< HEAD
//method to determine card color based on the suit
//restrict usage to members of the class; class users can't run this

private void determineColor(String suit) {
	
	if (suit.equalsIgnoreCase("clubs") || suit.equalsIgnoreCase("spades")) {
		color = "black";
	}
	else if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")) {
		color = "red";
	}
	else {
		color = "none";
	}
	
}

//method to display the values in a PlayingCard

public void showCard() {
	
	System.out.println("Suit: "  + suit);
	System.out.println("Value: " + value);
	System.out.println("Color: " + color);
	System.out.println("Image: " + image);
	System.out.println("Shape: " + shape);
	
=======
private void determineColor(String suit) {
	
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
	System.out.println("Card color: " + color);
	System.out.println("Card value: " + value);
	System.out.println("Card image: " + image);
	System.out.println("Card shape: " + shape);
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
}
}
