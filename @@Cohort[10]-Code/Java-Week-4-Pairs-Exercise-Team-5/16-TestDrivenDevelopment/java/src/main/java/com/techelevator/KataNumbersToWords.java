package com.techelevator;

public class KataNumbersToWords {

	public static String numberToWords(int number){
		String [] words = new String [1000000];
		words[0] ="";
		words[1] ="one";
		words[2] ="two";
		words[3] ="three";
		words[4] ="four";
		words[5] ="five";
		words[6] ="six";
		words[7] ="seven";
		words[8] ="eight";
		words[9] ="nine";
		words[10]="ten";
		words[11]="eleven";
		words[12]="twelve";
		words[13]="thirteen";
		words[14]="fourteen";
		words[15]="fifteen";
		words[16]="sixteen";
		words[17]="seventeen";
		words[18]="eighteen";
		words[19]="nineteen";
		words[20]="twenty";
		words[30]="thirty";
		words[40]="forty";
		words[50]="fifty";
		words[60]="sixty";
		words[70]="seventy";
		words[80]="eighty";
		words[90]="ninety";
		
			if(number > 19 && number < 100) {
			int holder = number % 10;
			number -= holder;
				return words[number] + "-" + words[holder];
				}
			if(number == 0) {
				return "zero";
			}
			if (number > 10 && number <= 19) {
				return words[number];
				}
			if(number > 100 && number <= 999) {
				int holder = number % 100;
				return words[number] + "hundred and " + words[holder]; 
			}
		return words[number];
	}
		
		
	
	
}
