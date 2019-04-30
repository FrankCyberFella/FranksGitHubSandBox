package com.techelevator;

public class FruitTree {

private String typeOfFruit;
private int piecesOfFruitLeft;

public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
	this.typeOfFruit = typeOfFruit;
	piecesOfFruitLeft = startingPiecesOfFruit;

}

public boolean pickFruit(int numberOfPiecesToRemove) {
	if(piecesOfFruitLeft > 0) {
		piecesOfFruitLeft -= numberOfPiecesToRemove;
		return true;
	}else {
		return false;
	}
	
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
