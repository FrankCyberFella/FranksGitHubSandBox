package com.techelevator.park;

import java.time.LocalDate;

public class Park {
	//defined data members
	private int parkId;
	private String name;
	private String location;
	private LocalDate establishDate;
	private int area;
	private int visitors;
	private String description;
	
	/**
	 * @return the parkId
	 */
	public int getParkId() {
		return parkId;
	}
	/**
	 * @param parkId the parkId to set
	 */
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the establishDate
	 */
	public LocalDate getEstablishDate() {
		return establishDate;
	}
	/**
	 * @param establishDate the establishDate to set
	 */
	public void setEstablishDate(LocalDate establishDate) {
		this.establishDate = establishDate;
	}
	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}
	/**
	 * @return the visitors
	 */
	public int getVisitors() {
		return visitors;
	}
	/**
	 * @param visitors the visitors to set
	 */
	public void setVisitors(int visitors) {
		this.visitors = visitors;
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
	
	public String toString() {
		String fullInfo = String.format("%s\n"
										+"Location:           %s\n"
										+"Established:        %s\n"
										+"Area:               %,d sq km\n"
										+"Annual Visitors:    %,d\n\n"
										+"%s", 
										this.getName()
										,this.getLocation()
										,this.getEstablishDate().toString()
										,this.getArea()
										,this.getVisitors()
										,this.getDescription());
				

		return fullInfo;
	}

}