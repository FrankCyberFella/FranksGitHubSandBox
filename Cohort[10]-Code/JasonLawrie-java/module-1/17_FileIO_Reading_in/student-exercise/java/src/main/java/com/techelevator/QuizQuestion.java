package com.techelevator;

public class QuizQuestion {

	private String question;
	private String[] answer;
	private int corAnswer;
	
	
	public QuizQuestion(String quizQuestion) {
		question=quizQuestion.substring(0,quizQuestion.indexOf('|'));
		String[] answers = quizQuestion.split("\\|");
		answer=new String[answers.length-1];
		for(int i = 1;i<answers.length;i++) {
			
			answer[i-1]=answers[i];
			if(answer[i-1].contains("*")) {
				corAnswer=i;
				answer[i-1]=answer[i-1].substring(0,answer[i-1].length()-1);
			}
		}
		

	}


	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}


	/**
	 * @return the answer
	 */
	public String[] getAnswer() {
		return answer;
	}


	/**
	 * @return the corAnswer
	 */
	public int getCorAnswer() {
		return corAnswer;
	}
}
