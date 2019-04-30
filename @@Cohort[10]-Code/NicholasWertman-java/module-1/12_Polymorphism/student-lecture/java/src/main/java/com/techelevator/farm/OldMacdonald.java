package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		
		//datatype 			  content/initial-value
		
		FarmAnimal anAnimal = new FarmAnimal ("Sheep", "baa!");	  //super class can be used to define objects of subclass
		FarmAnimal	Bessie  = new Cow ();						//super class can be used to define objects of subclass
		FarmAnimal	FogHorn = new Chicken();						//super class can be used to define objects of subclass
		
	System.out.println("first sound: " +	anAnimal.getSound());
	System.out.println("second sound: " +	Bessie.getSound());
	System.out.println("third sound: " +	FogHorn.getSound());
		
		
		
		
		
		
		  FarmAnimal[] someFarmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };
		  
		  for(FarmAnimal animal : someFarmAnimals) { String name = animal.getName(); String
		  sound = animal.getSound();
		  System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
		  System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
		  System.out.println("With a "+sound+" "+sound+" here");
		  System.out.println("And a "+sound+" "+sound+" there");
		  System.out.println("Here a "+sound+" there a "+sound+" everywhere a "
		  +sound+" "+sound); System.out.println(); 
		  }
		 
	}
}