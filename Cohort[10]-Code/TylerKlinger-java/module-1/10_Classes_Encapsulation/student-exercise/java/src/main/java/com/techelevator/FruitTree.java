package com.techelevator;

public class FruitTree {
	
	//data members
		private int piecesOfFruitLeft;
		private String typeOfFruit;
		//private int startingPiecesOfFruit;
		
		
	//CTOR	
		public FruitTree (String typeOfFruit, int startingPiecesOfFruit) {
			piecesOfFruitLeft = startingPiecesOfFruit;
			this.typeOfFruit = typeOfFruit;
		
		}

		
	//Setters and Getters
		public String getTypeOfFruit() {
			return typeOfFruit;
		}


		public int getPiecesOfFruitLeft() {
			return piecesOfFruitLeft;
		}
		
		
			
	//Class Methods	
		
		public boolean pickFruit(int piecesOfFruitToRemove) {
			//return true if fruit was picked
			// return false if no fruit is left to be picked
			
		if (piecesOfFruitLeft >= piecesOfFruitToRemove) {
			piecesOfFruitLeft = piecesOfFruitLeft - piecesOfFruitToRemove;
			return true;
		}
		return false;
		}
		
}
			

