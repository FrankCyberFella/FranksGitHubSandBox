package Quadax.techelevator;

import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		// Took around 25 minutes to get the final solution
		String masterLine = "";
		int numberOfGuesses = 0;

		for (int i = 0; i< 4; i++) {
			masterLine += ((int)(Math.random()*6)+1);			
		}
		
		boolean isCorrect = false;
	
		for (; numberOfGuesses < 10; numberOfGuesses++) {
			boolean isProperNum = false;
			String input = "";
			
			while(!isProperNum) {
				try {
					isProperNum = true;
					System.out.print("Please enter a valid guess: ");
					Scanner keyboard = new Scanner(System.in);
					input = keyboard.nextLine();
					int test = Integer.parseInt(input);
					if (input.length() != 4) {
						isProperNum = false;
					}
				} catch (NumberFormatException e) {
					isProperNum = false;
				}
				
			}
			
			
			
			
			isCorrect = guessTheKey(masterLine,input);
			if (isCorrect) {
				System.out.println("Hooray you won in " + (numberOfGuesses + 1) + " guesses");
				break;
			}
		}
		
		if (isCorrect == false) {
			System.out.println("Sorry the correct answer was " + masterLine);
		}
	}
	
	public static boolean guessTheKey(String masterLine, String guess) {
		String[] result = new String[4];
		for (int i = 0; i < 4; i++) {
			if (masterLine.charAt(i)==guess.charAt(i)) {
				System.out.print("+,");
			} else if (masterLine.contains(guess.charAt(i)+ "")){
				System.out.print("-,");
			} else {
				System.out.print(" ,");
			}
		}
		System.out.println();
		if (guess.equals(masterLine)) {
			return true;
		}
		return false;
	}

}
