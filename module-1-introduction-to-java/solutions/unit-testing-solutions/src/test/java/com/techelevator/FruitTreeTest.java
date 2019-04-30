package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FruitTreeTest {
	
	@Test
	public void fruitTreeInitializedCorrectly() {
		FruitTree ft = new FruitTree("Apple", 37);
		Assert.assertEquals("Apple", ft.getTypeOfFruit());
		Assert.assertEquals(37, ft.getPiecesOfFruitLeft());
	}

	@Test
	public void pickMaximumPiecesOfFruitLeft() {
		FruitTree ft = new FruitTree("Apple", 37);
		Assert.assertTrue(ft.PickFruit(37));
		Assert.assertEquals(0, ft.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pickMoreThanTheNumberOfPiecesOfFruitLeft() {
		FruitTree ft = new FruitTree("Apple", 37);
		Assert.assertFalse(ft.PickFruit(38));
		Assert.assertEquals(37, ft.getPiecesOfFruitLeft());
	}
}
