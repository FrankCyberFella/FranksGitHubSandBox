package com.techelevator.validation.model;

import org.hibernate.validator.constraints.NotBlank;


//import org.hibernate.validator.constraints.NotBlank;

public class ActorSearch {
//	
//	@NotBlank(message= "Please provide an actor")
	@NotBlank(message="Email is required")
	private String actor;

	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

}
