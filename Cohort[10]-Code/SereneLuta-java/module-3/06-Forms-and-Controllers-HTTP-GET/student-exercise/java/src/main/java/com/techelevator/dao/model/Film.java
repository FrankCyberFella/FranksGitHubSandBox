package com.techelevator.dao.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


import org.hibernate.validator.constraints.NotBlank;

/**
 * Film
 */
public class Film {
    private String title;
    private String description;
    private int releaseYear;
    
    @Min(value = 0, message = "The value must be positive")
    private int minLength;
    
    @Max(value = 250, message = "The value is too high")
    private int maxLength;
    private int length;
    
    private String rating;
    private String name;
    
    public Film() {};
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the length
	 */
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getMinLength() {
		return minLength;
	}
	/**
	 * @param length the length to set
	 */
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	public int getMaxLength() {
		return maxLength;
	}
	
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
}