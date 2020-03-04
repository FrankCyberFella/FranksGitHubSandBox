package com.survivorpoolcle.model.players;

import java.util.Objects;

public class Players {
private int 	playerId;
private String 	firstName;
private String 	lastName;
private String 	email;
private String 	mailingAddress;
private String 	cellPhone;
private String 	workPhone;
private String 	homePhone;

/**
 */
public Players() {
}
/**
 * @param playerId
 * @param firstName
 * @param lastName
 */
public Players(int playerId, String firstName, String lastName) {
	this.playerId = playerId;
	this.firstName = firstName;
	this.lastName = lastName;
}

/**
 * @return the playerId
 */
public int getPlayerId() {
	return playerId;
}
/**
 * @param playerId the playerId to set
 */
public void setPlayerId(int playerId) {
	this.playerId = playerId;
}
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the mailingAddress
 */
public String getMailingAddress() {
	return mailingAddress;
}
/**
 * @param mailingAddress the mailingAddress to set
 */
public void setMailingAddress(String mailingAddress) {
	this.mailingAddress = mailingAddress;
}
/**
 * @return the cellPhone
 */
public String getCellPhone() {
	return cellPhone;
}
/**
 * @param cellPhone the cellPhone to set
 */
public void setCellPhone(String cellPhone) {
	this.cellPhone = cellPhone;
}
/**
 * @return the workPhone
 */
public String getWorkPhone() {
	return workPhone;
}
/**
 * @param workPhone the workPhone to set
 */
public void setWorkPhone(String workPhone) {
	this.workPhone = workPhone;
}
/**
 * @return the homePhone
 */
public String getHomePhone() {
	return homePhone;
}
/**
 * @param homePhone the homePhone to set
 */
public void setHomePhone(String homePhone) {
	this.homePhone = homePhone;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	return Objects.hash(cellPhone, email, firstName, homePhone, lastName, mailingAddress, playerId, workPhone);
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Players other = (Players) obj;
	return Objects.equals(cellPhone, other.cellPhone) && Objects.equals(email, other.email)
			&& Objects.equals(firstName, other.firstName) && Objects.equals(homePhone, other.homePhone)
			&& Objects.equals(lastName, other.lastName) && Objects.equals(mailingAddress, other.mailingAddress)
			&& playerId == other.playerId && Objects.equals(workPhone, other.workPhone);
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Players [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", mailingAddress=" + mailingAddress + ", cellPhone=" + cellPhone + ", workPhone=" + workPhone
			+ ", homePhone=" + homePhone + ", getPlayerId()=" + getPlayerId() + ", getFirstName()=" + getFirstName()
			+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getMailingAddress()="
			+ getMailingAddress() + ", getCellPhone()=" + getCellPhone() + ", getWorkPhone()=" + getWorkPhone()
			+ ", getHomePhone()=" + getHomePhone() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
			+ ", toString()=" + super.toString() + "]";
}




}
