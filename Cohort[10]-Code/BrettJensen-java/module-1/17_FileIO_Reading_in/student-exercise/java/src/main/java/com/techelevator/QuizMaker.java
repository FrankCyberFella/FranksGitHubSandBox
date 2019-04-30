package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = getNewFile();
		
		try(Scanner input = new Scanner(file)){
			int correctAnswers = 0;
			while(input.hasNextLine()) {
				String line = input.nextLine();
				QuizQuestion question = new QuizQuestion(line);
				question.askQuestion();
				correctAnswers = question.getCorrectAnswerCount();
			}
			System.out.println("You answered " + correctAnswers + " correctly");
		}

	}


	public static File getNewFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("Where is the quiz file?");
		String p = input.nextLine();
		File file = new File(p);
		if(file.canExecute() == false) {
			System.out.println("The File can not be opened");
			System.exit(1);
		}
		if(file.exists() == false) {
			System.out.println("The File does not exist");
			System.exit(1);
		}
		return file;
	}
	
	
}
