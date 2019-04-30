package com.techelevator;

public class PlayingCard {
<<<<<<< HEAD
//define the data members of the class
private String suit;
private String color;
private int value;
private String image;
private String shape;
private String gender;
=======
// define the data members of the class
private String suit;
private String color;
private int    value;
private String image;
private String shape;
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf

// define methods for the class

// default constructor - assign default values to data of the class

<<<<<<< HEAD
private void determineColor(String suit) {
	if (suit.equals("Clubs") || suit.equals("Spades")){
		color = "Black";
	}
	else if (suit.equals("Hearts") || suit.equals("Diamonds")){
		color = "Red";
	}
	else color = "TAKE THE DAMN JOKERS OUT OF THE DECK";
}
// ctor for a card for only a suit and a value
public PlayingCard(String suit, int value) {
	//keyword "this" indicates a member in the object that is being processed
	//this. shows that you want the data in the current object
	//or just change the variable names in the constructor
	//very common to keep them the same name though, so this. will be used
	this.suit = suit;
	determineColor(suit);
	this.value = value;
	image = value + " " + color + " " + suit;
	shape = "rectangle";
	gender = "female";
}

//ctor to create card with suit value image and shape

=======
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
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public PlayingCard(String suit, int value, String image, String shape) {
	this.suit = suit;
	determineColor(suit);
	this.value = value;
	this.image = image;
	this.shape = shape;
<<<<<<< HEAD
}
//method to determine the card color based on the suit
// method to display the card values


public String getSuit() {
	return suit;
}
public void setSuit(String suit) {
	this.suit = suit;
}
=======
}	


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
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
public int getValue() {
	return value;
}
public String getValueName() {
<<<<<<< HEAD
	switch (value) {//check the value in the variable give
	case 1:
		return "Ace";
	case 2:
		return"Two";
	case 3:
		return"Three";
	case 4:
		return"Four";
	case 5:
		return"Five";
	case 6:
		return"Six";
	case 7:
		return"Seven";
	case 8:
		return"Eight";
	case 9:
		return"Nine";
	case 10:
		return"Ten";
	case 11:
		return"Jack";
	case 12:
		return"Queen";
	case 13:
		return"King";
	}
	return "Not a valid card value";
}
public void setValue(int value) {
	this.value = value;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getShape() {
	return shape;
}
public void setShape(String shape) {
	this.shape = shape;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getColor() {
	return color;
}
public void showCard() {
	System.out.println("Card suit: " + suit);
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
<<<<<<< HEAD
	System.out.println("Card gender: " + gender);
	}
=======
}
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
}
