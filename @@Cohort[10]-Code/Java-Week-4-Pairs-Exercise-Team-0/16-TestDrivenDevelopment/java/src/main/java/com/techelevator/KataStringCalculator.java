package com.techelevator;

public class KataStringCalculator {
		private String numbers = "";
		private int addingInts;
		private int sumOfInts = 0;
		
		public KataStringCalculator(String numbers) {
			this.numbers = "";
			
		}
		
		public KataStringCalculator(int sumOfInts) {
				this.sumOfInts = sumOfInts;
			}

		
		public int add(String numbers) {
			String[] sumOfString = numbers.split("[\n,]");
			int sum = 0;
			for(String stringNumber: sumOfString) {
				if(numbers == "") {
					return 0;
				}
				Integer sumInts = Integer.parseInt(stringNumber);
				sum += sumInts;
			}
			return sum;
		}
			

}
		
	


