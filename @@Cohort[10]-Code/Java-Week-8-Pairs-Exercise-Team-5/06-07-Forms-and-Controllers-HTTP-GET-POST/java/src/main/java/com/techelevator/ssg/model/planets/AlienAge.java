package com.techelevator.ssg.model.planets;



public class AlienAge {

	private int age;
	private String planet;
	

	public AlienAge(int age, String planet) {
		this.age = age;
		this.planet = planet;
	
	}
	
	public double calculateAge() {
		switch(planet) {
		case "Mercury":
			return age/0.241;
		case "Venus":
			return age/0.615;
		case "Earth":
			return age/1;
		case "Mars":
			return age/1.881;
		case "Jupiter":
			return age/11.86;
		case "Saturn":
			return age/29.46;
		case "Uranus":
			return age/84.01;
		case "Neptune":
			return age/164.8;
		}
		return 0;
	}
	
	
	
//	Mercury 0.241 yrs 
//	Venus 0.615 yrs 
//	Earth 1.000 yrs 
//	Mars 1.881 yrs 
//	Jupiter 11.86 yrs 
//	Saturn 29.46 yrs 
//	Uranus 84.01 yrs 
//	Neptune 164.8 yrs 
//	Pluto (dwarf planet) 248.6 yrs
//
//	Now what you do is divide your age in Earth years by the
//	length of the planet's year in Earth years to get you age in that planets years.
//
//	For example, if I were 21 Earth years old, 
//	I would be 21/0.241 = 87 Mercury years old 
//	and 21/248.6 = 0.08 Pluto years old.
	
	
}
