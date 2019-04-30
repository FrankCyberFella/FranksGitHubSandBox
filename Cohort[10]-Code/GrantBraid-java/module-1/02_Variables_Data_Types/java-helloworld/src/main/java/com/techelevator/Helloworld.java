// - two slashes in a row indicate a comment - ignored by compiler
// - a comment is information for any human looking at code

package com.techelevator; // identifies the package the program belongs to

import java.util.Scanner;

// provides a context for names

public class Helloworld {	// Every Java program is a class

	public static void main(String[] args) { // a Java function/program
		
		Scanner kb = new Scanner(System.in);
		int one = 0;
		int two = 0;
		int three = 0;
		
		one = kb.nextInt();
		two = kb.nextInt();
		three = kb.nextInt();
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		
//		 String result = "0\n1\n2,3";
//		 System.out.println(result);
//		 result = result.replaceAll("\n",",");
//		 System.out.println(result);
//		    String[] result2 = result.split(",");
//		    System.out.println(result2);
//		    for (String resut: result2) {
//		    	System.out.print(resut + " ");
//		    }
//						//Integer.					 // main() - is the primary function of a program
//		System.out.println("Hello, world. My name is STEVEVE"); // This displays whatever inside the () on screen
	}

}
