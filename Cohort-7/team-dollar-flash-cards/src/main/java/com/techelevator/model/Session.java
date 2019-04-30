package com.techelevator.model;

import java.util.List;

public class Session {
	
	private List<Card> correct;
	private List<Card> incorrect;
	private List<Card> skipped;
	
	public List<Card> getCorrect() {
		return correct;
	}
	public void setCorrect(List<Card> correct) {
		this.correct = correct;
	}
	public List<Card> getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(List<Card> incorrect) {
		this.incorrect = incorrect;
	}
	public List<Card> getSkipped() {
		return skipped;
	}
	public void setSkipped(List<Card> skipped) {
		this.skipped = skipped;
	}

}
