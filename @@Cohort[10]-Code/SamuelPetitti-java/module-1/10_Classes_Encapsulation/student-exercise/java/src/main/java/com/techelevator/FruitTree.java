package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if(numberOfPiecesToRemove > getPiecesOfFruitLeft()) {
			return false;
		} else {
			if(numberOfPiecesToRemove <= piecesOfFruitLeft) {
			   piecesOfFruitLeft -= numberOfPiecesToRemove;
			}
		}  return true;
		 
	}

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
		

}



