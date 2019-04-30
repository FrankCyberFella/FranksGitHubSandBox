package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizQuestion {
	
	private String question;
	List<String> possibleAnswers = new ArrayList<String>();
	private int correctAnswer;
	private static int correctAnswers = 0;

	
	public QuizQuestion(String questionComponents) {
		String[] components = questionComponents.split("\\|");
		for(int i = 0; i < components.length; i++) {
			if(i == 0) {
				this.question = components[i];
			} else {
				if(components[i].contains("*")) {
					components[i] = components[i].replace("*", "");
					possibleAnswers.add(components[i]);
					correctAnswer = i;
				}
				else {
					possibleAnswers.add(components[i]);
				}
			}
		}
	}
	
	
	public void askQuestion() {
		Scanner input = new Scanner(System.in);
		int count = 1;
		String questionOutput = "*********\n" + "Question:\n" + "*********\n";
		questionOutput += question + "\n";
		for(String answer : possibleAnswers) {
			questionOutput += count + "] " + answer + "\n";
			count++;
		}
		System.out.println(questionOutput);	
		String answer = input.nextLine();
		if(checkAnswer(answer)) {
			correctAnswers++;
		}
	}
	
	public boolean checkAnswer(String answer) {
		int num = Integer.parseInt(answer);
		if(num == correctAnswer) {
			System.out.println("Your answer: " + answer + "\n");
			System.out.println("Wooooo! That's Correct!\n\n");
			return true;
		} else {
			System.out.println("Your answer: " + answer + "\n");
			System.out.println("Sorry! That's Incorrect!\n\n");
			return false;
		}
	}
	
	public int getCorrectAnswerCount() {
		return correctAnswers;
	}
}
