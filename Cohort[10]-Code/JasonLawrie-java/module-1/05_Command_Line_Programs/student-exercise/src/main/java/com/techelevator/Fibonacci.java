package com.techelevator;
import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int prev2=0;
		int prev1=1;
		int current=prev1+prev2;
		int userMax=0;
		String userString="";
		System.out.print("Please enter the maximum number to list in the Fibonacci sequence: ");
		userString=keyboard.nextLine();
		userMax=Integer.parseInt(userString);
		System.out.print(prev2+", "+prev1);
		
		while(prev1+prev2<=userMax) {
			current=prev1+prev2;
			System.out.print(", "+current);
			prev2=prev1;
			prev1=current;
		}
		
	}

}
