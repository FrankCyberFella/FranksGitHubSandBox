package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree (String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		piecesOfFruitLeft = startingPiecesOfFruit;
		
	}
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if(piecesOfFruitLeft == 0) {
			return false;
		}
		else {
			if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
				piecesOfFruitLeft -= numberOfPiecesToRemove;
				return true;
			}
			return false;
		}
	}

	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

	public String getTypeOfFruit(String typeOfFruit) {
		return typeOfFruit;
	}
}
