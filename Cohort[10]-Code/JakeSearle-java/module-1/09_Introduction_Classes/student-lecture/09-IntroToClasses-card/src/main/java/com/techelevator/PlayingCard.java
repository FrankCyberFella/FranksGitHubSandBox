package com.techelevator;

public class PlayingCard {
// define the data members of the class
<<<<<<< HEAD
private String suit; 
private String color;
private int	   value;
=======
private String suit;
private String color;
private int    value;
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
private String image;
private String shape;

// define methods for the class

<<<<<<< HEAD
// define default constructor - assigns default values to the data of the class

public PlayingCard() {
	suit = "Joker";
	color = "red";                                     // this is a constructor. Must be PascalCase
	value = 0;
	image = "jester";
	shape = "rectangle";

}

// ctor is used to abbreviate constructor. ctor for card for only suit and value
public PlayingCard(String suit, int value) {
	this.suit = suit;
	if (suit.equals("Clubs") || suit.equals("Spades")) {     // you can run determineColor method from below instead as well
			color = "black";      
	} 
	else {
		if (suit.equals("Hearts") || suit.equals("Diamonds")) {
			color = "red";    
	} 	
		else {
		
				color = "unknown";   
		}                                        // you can change name of value, or or use keyword "this.name". Indicates      
	}
	this.value = value;							 // a member in the object being processed. i.e. suit = suit becomes
	image = value + " " + suit;                  // this.suit = suit. Can also alternatively change the names of the 
	shape = "rectangle";                         // values in the parameters. 
 
	
    }

//ctor to create card with suit, value, image, and shape
public PlayingCard(String suit, int value, String image, String shape) {
	this.suit = suit; 
	determineColor(suit);
	this.value = value;							 
	this.image = image;                   
	this.shape = shape;
}





=======
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
public String getValueName() {
<<<<<<< HEAD
	switch (value) {          // switch says to check the value in the variable specified
	case 1:
		return "Ace";
	case 2:
		return "Two";
	case 3:
		return "Three";
=======
	switch (value) {  // check the value in the variable give
	case 1:           // if the value is this...
		return "Ace"; // do this
	case 2:
		return "Two";
	case 3:
		return "Three";	
>>>>>>> fa9d93e0ea31406930c4915172a3e8ebbec35daf
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
<<<<<<< HEAD

=======
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
//method to determine the card color based on the suit
//private to restrict usage to class members - dont want class users to be able to run it
private void determineColor(String suit) {
	this.suit = suit;
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

public void showCard() {
	System.out.println("Card suit is: " + suit);
	System.out.println("Card color is: " + color);
	System.out.println("Card value is: " + value);     
	System.out.println("Card image is: " + image);
	System.out.println("Card shape is: " + shape);
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
