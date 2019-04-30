package com.techelevator.model;

import java.util.List;

import javax.validation.constraints.Size;

public class Card {

	private Long cardId;
	@Size(max = 512, message = "Your message has too many characters")
	private String frontText;
	@Size(max = 512, message = "Your message has too many characters")
	private String backText;
	private List<String> keyword;
	private List<Double> deckId;

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getFrontText() {
		return frontText;
	}

	public void setFrontText(String frontText) {
		this.frontText = frontText;
	}

	public String getBackText() {
		return backText;
	}

	public void setBackText(String backText) {
		this.backText = backText;
	}

	public List<String> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

	public List<Double> getDeckId() {
		return deckId;
	}

	public void setDeckId(List<Double> deckId) {
		this.deckId = deckId;
	}

}
