package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User
 */
public class User {
	@Email
    @NotBlank(message="Username is required")
    private String username;

    @NotBlank(message="Role is required")
    private String role;
    private long id;

    @NotBlank(message="Password is required")
    private String password;
    private String confirmPassword;

    @NotBlank(message="City is required")
    private String city;
    @NotBlank(message="State is required")
    private String state;
    @NotBlank(message="An initial preference is required.  (You can change this later!)")
    private String current_preference;
    
    private int visits;
      
    /*private boolean passwordMatching;
    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmPassword);
        }
        return true;
    }
    */
    
    
    public int getVisits() {
		return visits;
	}



	public void setVisits(int visits) {
		this.visits = visits;
	}



	/**
	 * @return the current_preference
	 */
	public String getCurrent_preference() {
		return current_preference;
	}



	/**
	 * @param current_preference the current_preference to set
	 */
	public void setCurrent_preference(String current_preference) {
		this.current_preference = current_preference;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}