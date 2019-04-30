package com.techelevator; //identifies the package the program belongs to

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

//provides a context for names

public class Helloworld { //every Java program is a class

	public static void main(String[] args) {  //a Java function for a program
										//main() is the primary function in a Java program
										//this displays whatever is inside the () on screen
		System.out.println("Hello, world. My name is Sam Petitti.");
		
		String bad = "xbadbad";
		System.out.println(bad.substring(1,4));
		
		String str = "sAMSAM";
		System.out.print(str.substring(str.length()-1, str.length()));
		String newStr = str.replace("A", "");
		//System.out.println(".replace =" + newStr);
		
		
//List<Integer> numsList = new ArrayList<Integer>(Arrays	.asList(4 , 4, 23, 5, 2, 77, 4, 6, 0 , 2 ,4 ,3, 11));
////		
//		public String moreOddsEvens(List<Integer> integerList) {
//			int odds = 0;
//			int evens = 0;
//			for(Integer num : integerList) {
//				if(num % 2 == 0) {
//					evens ++;
//				} else {
//					odds++;
//				}
//			}
//			if(odds > evens) {
//				return "odds";
//			} else {
//				return "evens";
//			}
//		}
//		
//	}
		
		

}
