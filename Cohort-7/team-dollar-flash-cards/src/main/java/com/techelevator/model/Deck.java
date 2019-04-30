package com.techelevator.model;

import java.util.List;

import javax.validation.constraints.Size;

public class Deck {

	private Long deckId;
	private String deckName;
	@Size(max = 255, message = "Your description is too long, please enter less than 255 characters")
	private String deckDesciption;
	private String userName;
	private Boolean isPublic;

	public Long getDeckId() {
		return deckId;
	}

	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String name) {
		this.deckName = name;
	}

	public String getDeckDescription() {
		return deckDesciption;
	}

	public void setDeckDescription(String description) {
		this.deckDesciption = description;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getDeckDesciption() {
		return deckDesciption;
	}

	public void setDeckDesciption(String deckDesciption) {
		this.deckDesciption = deckDesciption;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
