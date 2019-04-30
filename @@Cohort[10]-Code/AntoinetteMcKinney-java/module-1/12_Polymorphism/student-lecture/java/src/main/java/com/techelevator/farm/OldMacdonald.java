package com.techelevator.farm;

import java.lang.reflect.Array;

public class OldMacdonald {
	public static void main(String[] args) {
		
//       datatype             content/initial-value		
		//Super class may be used to define objects of subclass. We changed it to all FarmAnimal 
		FarmAnimal anAnimal = new FarmAnimal("Sheep", "baa"); // //defining new animal and giving it a name and sound
		FarmAnimal	Bessie  = new Cow();
		FarmAnimal  FogHorn	= new Chicken();
		
	    System.out.println(anAnimal.getSound()); // to do something with the return value so that you can see whatever getsound retrurns 
	    System.out.println(Bessie.getSound()); 
	    System.out.println(FogHorn.getSound());
	    
	    /*created an on someFarmAnimals. a cow in first elemnt (0) and chicken in second element (1)
	     * The dataType is farmAnimal Class
	     */											//element (0)
		FarmAnimal[] someFarmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };//An Array of someFarmAnimals .
		
		//Going through one element at a time. The forEach goes throguh loop from beginning to end. 
		// As we go through the loop animal.getName and animal.getSound. Data type of animal is a FarmAnimal object
		// because data type says in ForEach loopl. first time animal will be cow object. The second time the chicken object will go. 
		//The first time used cow object. the Second time used chicken object to run the methods. 
		// It choose the method based on the datatype in the object NOT the datatype OF the object.
		//This makes it be polymorphism. our array is FarmAnimal so we ran the object. If you declare
		// a collection of based objects. Y
		for(FarmAnimal animal : someFarmAnimals) {
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
