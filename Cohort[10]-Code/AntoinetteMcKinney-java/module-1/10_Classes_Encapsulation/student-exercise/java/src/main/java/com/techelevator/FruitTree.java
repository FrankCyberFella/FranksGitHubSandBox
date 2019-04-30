package com.techelevator;

public class FruitTree {
	// VARIABLES OR DATA MEMBERS
	private String typeOfFruit; // These are what the object knows
	private int piecesOfFruitLeft;

	// CONSTRUCTORS // method to create an instance of a class,
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.piecesOfFruitLeft = startingPiecesOfFruit;
		this.typeOfFruit = typeOfFruit;

	}

	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */

	public String getTypeOfFruit() {// The type of fruit on the tree.
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {// The number of remaining fruit pieces on the tree.
		return piecesOfFruitLeft;
	}

	// METHODSS
	public boolean pickFruit(int numberOfPiecesToRemove) {// Method
		/*
		 * piecesOfFruitLeft is the number of fruit on the tree. numberOfPiecesToRemove
		 * is the number of fruit that will be picked off the tree.
		 * 
		 * (numberOfPiecesToRemove <= piecesOfFruitLeft) -> return true; Update the
		 * piecesOfFruitLeft after fruit is picked -> piecesOfFruitLeft -=
		 * numberOfPiecesToRemove;
		 * 
		 */

		if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
			piecesOfFruitLeft -= numberOfPiecesToRemove;
			return true;
		} else {
			return false;
		}
	}
}
