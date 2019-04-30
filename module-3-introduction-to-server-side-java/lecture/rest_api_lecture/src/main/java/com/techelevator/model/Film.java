package com.techelevator.model;

public class Film {
	private long id;
	private String title;
	private String rating;
	private String description;
	private Integer releaseYear;
	private Integer runTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public Integer getRunTime() {
		return runTime;
	}
	public void setRunTime(Integer length) {
		this.runTime = length;
	}
}
