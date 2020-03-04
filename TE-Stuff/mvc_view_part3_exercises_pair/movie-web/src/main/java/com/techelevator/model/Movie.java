package com.techelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Movie {

	private static AtomicLong idSequence = new AtomicLong(1);
	private Long id;
	private String name;
	private String genre;
	private String description;
	private int runningTime;
	private int yearReleased;

    public List<ShowTime> showTimes;
    public List<String> cast;
	
	public Movie(String name, String description, int runningTime, int yearReleased, String genre) {
		this.id = idSequence.getAndIncrement();
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.runningTime = runningTime;
		this.yearReleased = yearReleased;
		this.showTimes = new ArrayList<ShowTime>();
	    this.cast = new ArrayList<String>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}

	public String getDescription() {
		return description;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public List<ShowTime> getShowTimes() {
		return Collections.unmodifiableList(showTimes);
	}
	
	public void addShowTime(ShowTime showTime) {
		showTimes.add(showTime);
	}

	public List<String> getCast() {
		return Collections.unmodifiableList(cast);
	}

	public void addCastMember(String castMember) {
		cast.add(castMember);
	}
}
