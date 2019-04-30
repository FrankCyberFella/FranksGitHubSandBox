package com.techelevator.validation.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class FilmSearch {

	@Min(value=0, message="Must have a value")
	private int minLength;
	
	@Min(value=0, message="Must have a value")
	private int maxLength;
	
	private String genre;

	@SuppressWarnings("unused")
	private boolean maxGreaterThanMin; // Dummy property to get matching vaildation working
	@AssertTrue(message="Max value must be greater than min")
	public boolean ismaxGreaterThanMin() {
		if(maxLength > minLength) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
}
