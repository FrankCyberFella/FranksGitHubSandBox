package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal sheep = new FarmAnimal("Sheep", "*existential screaming*");
		FarmAnimal Bessie = new Cow();// data type of what Bessie contains
		// Bessie more or less contains Cow
		FarmAnimal fogHorn = new Chicken();

		System.out.println(sheep.getSound());
		System.out.println(Bessie.getSound());
		System.out.println(fogHorn.getSound());

		FarmAnimal[] someFarmAnimals = new FarmAnimal[] { Bessie, fogHorn, sheep };

		for (FarmAnimal animal : someFarmAnimals) {
			String name = animal.getName();// first time through it will be a Cow object because animal = Cow();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he\n had a " + name + ", ee\n, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
}