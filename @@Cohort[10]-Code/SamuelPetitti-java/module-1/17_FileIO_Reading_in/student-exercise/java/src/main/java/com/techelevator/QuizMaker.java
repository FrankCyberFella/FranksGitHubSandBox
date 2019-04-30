package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the file path: ");
		String path = userInput.nextLine();
		System.out.println("File path entered is: " + path);
		File quizFile = new File(path);
		int answeredCorrect = 0;
		int totalQuestions = 0;

		try (Scanner quizText = new Scanner(quizFile)) {
			while (quizText.hasNextLine()) {
				String qA = quizText.nextLine();
				String[] qASplit = qA.split("\\|");
				System.out.println(qASplit[0]);
				int answer = 0;
				for (int i = 1; i < qASplit.length; i++) {
					if (qASplit[i].contains("*")) {
						answer = i;
					}
					System.out.println(i + ". " + qASplit[i].replace("*", ""));
				}
				System.out.print("Your answer: \n");
				String userAnswerString = userInput.nextLine();
				int userAnswer = Integer.parseInt(userAnswerString);
				if (userAnswer == answer) {
					answeredCorrect ++;
					System.out.println("Correct!");
				} else {
					System.out.println("Wrong!");
				} totalQuestions ++;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You answered " + answeredCorrect + " out of " + totalQuestions + " "
				+ "questions correct.");

	}

}

//test_quiz.txt