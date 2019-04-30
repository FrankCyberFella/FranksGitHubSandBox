package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		

//		// datatype			 content/initial-value
//		FarmAnimal anAnimal = new FarmAnimal("Sheep", "baa");
//		FarmAnimal Bessie   = new Cow();
//		FarmAnimal FogHorn  = new Chicken();
//		
//		System.out.println(anAnimal.getSound());
//		System.out.println(Bessie.getSound());
//		System.out.println(FogHorn.getSound());
//		
		
	//FarmAnimal is a datatype, someFarmAnimals is an array, and holds newCow() and new Chicken();
FarmAnimal[] someFarmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };
		
		for(FarmAnimal animal : someFarmAnimals) {
//			Chooses method based on DATATYPE !IN! object, not !OF! object
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
	}
}