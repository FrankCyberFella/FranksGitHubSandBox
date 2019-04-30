package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	private int numberOfPiecesToRemove;
	

	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;

	}

	/**
	 * @return the typeOfFruit
	 */
	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	/**
	 * @return the piecesOfFruit
	 */
	public int getPiecesOfFruit() {
		return this.piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
	}

	public boolean pickFruit(int numberOfPiecesToRemove) {
		if (piecesOfFruitLeft > 0) {
			this.piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
			return true;
		} else {
			return false;
		}
	}

	public int getPiecesOfFruitLeft() {

		piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;

		return piecesOfFruitLeft;
	}

	{
	}
}
