package com.techelevator;//identifies the package the program belongs to
							//provides a context for names
public class Helloworld {//every java program is a class

	public static void main(String[] args) { // a java function
											//main() is the primary function
//		String string1 = "I am treating string as a simple datatype";
//		String string2 = new String("I am treating string as a class");
//		System.out.println(string1);
//		System.out.println(string2);
		String tempString ="";
		String drink = "old fashioned, sazerac";
		String severalDrinks[] = drink.split(", ");
		for(int j = 0; j<severalDrinks.length;j++) {
			String drinkOrder[]=severalDrinks[j].split(" ");
			for(int i=0;i<drinkOrder.length;i++) {
				tempString+=(drinkOrder[i].substring(0,1).toUpperCase()+drinkOrder[i].substring(1,drinkOrder[i].length())+" ");
			}
			severalDrinks[j]=tempString;
			System.out.println(severalDrinks[j]);
			tempString="";
		}
		

		
		
	}

}
