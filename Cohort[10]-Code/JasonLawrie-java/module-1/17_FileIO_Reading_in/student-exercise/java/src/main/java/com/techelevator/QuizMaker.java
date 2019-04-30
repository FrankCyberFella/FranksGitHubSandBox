package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		
		File inputFile = getInputFileFromUser();
		List<QuizQuestion> questions = new ArrayList<QuizQuestion>();
		String line = "";
		int rightAnswers=0;
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				if(line.length()!=0) {
					questions.add(new QuizQuestion(line));
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Oops");
		}
		for(QuizQuestion question:questions) {
			rightAnswers=askQuestion(question,rightAnswers);
		}
		System.out.println();
		System.out.print("You had "+ rightAnswers+" correct answer");
		if(rightAnswers==1) {
			System.out.println("!");
		} else {
			System.out.println("s!");
		}
		
	}
	
	private static int askQuestion(QuizQuestion question, int rightAnswers) {
		System.out.println(question.getQuestion());
		for(int i=0;i<question.getAnswer().length;i++) {
			System.out.println((i+1)+".  "+question.getAnswer()[i]);
		}
		System.out.println();
		int answer=answerGuess();
		//System.out.print("Your answer: "+answer);
		//System.out.println();
		if(answer==question.getCorAnswer()) {
			System.out.println("Correct!");
			rightAnswers++;
		} else {
			System.out.println("Incorrect!");
		}
		return rightAnswers;
	}
	
	private static int answerGuess() {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Your answer: ");
		String answer = userInput.nextLine();
		int retInt=0;
		try {
			retInt=Integer.parseInt(answer);
		} catch(NumberFormatException e){
			System.out.println("You done goofed. Enter a number next time.");
		}
		return retInt;
		
		
		
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the quiz file?");
		String path = userInput.nextLine();
		System.out.println("Path entered: "+ path + "\n");
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
}
