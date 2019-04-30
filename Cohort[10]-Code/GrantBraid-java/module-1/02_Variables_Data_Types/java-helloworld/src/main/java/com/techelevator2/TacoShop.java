package com.techelevator2;

public class TacoShop {

	public static void main(String[] args) {
		Taco taco1 = new Taco(5,4);
		Taco soft1 = new SoftTaco(5,3);
		taco1.getPrice();
		System.out.println(taco1.toString());
		System.out.println(soft1.toString());

		
	}
}
