package com.techelevator;

public class PlayingCard {
<<<<<<< HEAD
//define data members of the class
=======
// define the data members of the class
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
private String suit;
private String color;
private int    value;
private String image;
private String shape;

<<<<<<< HEAD
//define methods for the class

//default constructor - assign default values to data of the class
=======
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
<<<<<<< HEAD
//the keyword "this" indicates a member in the object being processed	
		this.suit = suit;
		if (suit.equals("Clubs") || suit.contentEquals("Spades")) {
			
		}else {
			if(suit.equals("Hearts") || suit.contentEquals("Diamonds")) {
			color = "red";	
			}
			else 
				color = "unknown";
			}
		this.value = value;
		this.image = value + " " + suit;
		this.shape = "rectangle";
		}
		


//method to display the values in a PlayingCard
//ctor to create card with suit, value, image, shape
public PlayingCard(String suit, int value, String image, String shape) {
	this.suit = suit;
	if (suit.equals("Clubs") || suit.contentEquals("Spades")) {
		color = "black";
	}else {
		if(suit.equals("Hearts") || suit.contentEquals("Diamonds")) {
		color = "red";	
		}
		else 
			color = "unknown";
		}
	this.value = value;
	this.image = image;
	this.shape = shape;
	
}
=======
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

>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
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
<<<<<<< HEAD

=======
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

<<<<<<< HEAD
// method to determine card color based on suit
//ristrict usage to members of the class - don't want class users to be able to run this
private void determineColor(String suit) {
	this.suit = suit;
	if (suit.equals("Clubs") || suit.contentEquals("Spades")) {
		color = "black";
	}else {
		if(suit.equals("Hearts") || suit.contentEquals("Diamonds")) {
		color = "red";	
	}
		else 
			color = "unknown";
	}
			
}
public void showCard() {
	System.out.println("Card suit: " + suit);
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
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
	System.out.println("Card color: " + color);
	System.out.println("Card value: " + value);
	System.out.println("Card image: " + image);
	System.out.println("Card shape: " + shape);
}
}
