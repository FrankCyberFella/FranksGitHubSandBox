package com.techelevator; //tells us the package the program belongs to
//also provides context for names


public class Helloworld { //Every Java program is a class

	public static void main(String[] args) { // a Java function/program
		String nums2 = "Stuff";
		System.out.println(nums2);
		System.out.println(letter(nums2));
	}
	
	public static String reverse(String letter) {
		char hold;
		char[] nums = letter.toCharArray();
		  int j = letter.length()-1;
		  for (int i = 0; i < letter.length() / 2; i++) {
		    hold = letter.charAt(i);
		    nums[i] = nums[j];
		    nums[j] = hold;
		    j--;
		  }
		return nums.toString();  
	}
	public static int[] prime (int[] nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i + ", ");
			}
			
		}
		return nums;
	}
	
	public static String reverse(char[] letter) {
		char hold;
		int j = letter.length-1;
		for (int i = 0; i < letter.length / 2; i++) {
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
		}
		return letter;
	}
	
	public static String FizzBuzz(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				return "FizzBuzz";
			}
			else if (i % 3 == 0) {
				return "Fizz";
			}
			else if (i % 5 == 0) {
				return "Buzz";
			}
		}
		return nums;
	}
	
	public static String prime (int[] nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				return (i + ", ");
			}
		}
	}
	
	public static String reverse (char[] letter) {
		char hold;
		int j = letter.length-1;
		for (int i = 0; i < letter.length / 2; i++) {
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
		}
		return letter;
	}
	public static String prime (int[] nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i + ", ");
			}
		}
	}
	public static String reverse (char[] letter) {
		char hold;
		int j = letter.length-1;
		for (int i = 0; i < letter.length / 2; i++) {
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
			}
		return letter;
	}
	public static String prime (int[] nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i + ", ");
			}
		}
	}
	public static String reverse (char[] letter) {
		char hold;
		int j = letter.length-1;
		for (int i = 0; i < letter.length / 2; i++) {
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
		}
		return letter;
	}
	public static String prime (int[] nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i + ", ");
			}
		}
	}
	public static char[] reverse (char[] letter) {
		char hold;
		int j = letter.length-1;
		for (int i = 0; i < letter.length / 2; i++) {
			hold = letter[i];
			letter[i] = letter[j];
			letter[j] = hold;
			j--;
		}
		return letter;
	}
	public static void prime (int nums) {
		for (int i = 2; i <= 100; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i + ", ");
			}
		}
	}
	public static void FizzBuzz (int nums) {
		for (int i = 0; i < nums.length-1; i++) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				System.out.println("FizzBuzz");
			}
			else if (i % 3 == 0) {
				System.out.println("Fizz");
			}
			else if (i % 5 == 0) {
				System.out.println("Buzz");
			}
			System.out.println(i + ", ");
		}
		
	}
	public int maxValue (int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length-1; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			return max;
		}
	}
	public int matchNum (int[] num1, int[] num2) {
		int isEqual;
		for (int i = 0; i < num1.length-1; i++) {
			isEqual = num1[i];
			for(int j = 0; j < num2.length-1; j++) {
				isEqual = num2[j];
			
			if (i == j) {
				return isEqual;
			}
			if (i > j) {
				return num1[i];
			}
				return num2[j];
			}
		}
		return 0;
	}
	
}
