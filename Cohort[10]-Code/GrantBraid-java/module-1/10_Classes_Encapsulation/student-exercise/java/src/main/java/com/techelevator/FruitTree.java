package com.techelevator;

public class FruitTree {

	private String typeOfFruit;
	private int piecesOfFruitLeft;
	/**
	 * @return the typeOfFruit
	 */
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	/**
	 * @return the piecesOfFruitLeft
	 */
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
		
	}
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		piecesOfFruitLeft = startingPiecesOfFruit;
	}
	
	public boolean pickFruit(int numberRemoved) {
		if (numberRemoved > 0 && piecesOfFruitLeft >= numberRemoved) {
			piecesOfFruitLeft -= numberRemoved;
			return true;
		}
		return false;
		
	}
}
