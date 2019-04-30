package com.techelevator;

public class FruitTree {

private String typeOfFruit;
private int piecesOfFruitLeft; 
private int finalFruit;

 

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

public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
	this.typeOfFruit = typeOfFruit;
	piecesOfFruitLeft = startingPiecesOfFruit;
}

public boolean pickFruit(int numberOfPiecesToRemove) {
	if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
		piecesOfFruitLeft -= numberOfPiecesToRemove;
		return true;
	} 
	else if (piecesOfFruitLeft == 0) {
		return false;
	}
	else if (numberOfPiecesToRemove >= piecesOfFruitLeft) {
		return false;
	} return true;
}
}