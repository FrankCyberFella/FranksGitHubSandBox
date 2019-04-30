package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit; //created data members
	private int piecesOfFruitLeft;
	
	//created ctor with parameters to set the data members because there were no setter available
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}
	
	//created the getters
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
	//created the method required
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if(numberOfPiecesToRemove <= this.piecesOfFruitLeft) {
			piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
			return true;
		}else {
			return false;
		}
	}
}
