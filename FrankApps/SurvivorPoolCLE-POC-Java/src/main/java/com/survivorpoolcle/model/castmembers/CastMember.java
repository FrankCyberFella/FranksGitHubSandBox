package com.survivorpoolcle.model.castmembers;

public class CastMember {
private int seasonId;
private int survivorId;
private int dayVotedOut;
private int originalTribe;
private int currentTribe;
private int secondTribe;
private int thirdTribe;
private int fourthTribe;
/**
 * @return the seasonId
 */
public int getSeasonId() {
	return seasonId;
}
/**
 * @param seasonId the seasonId to set
 */
public void setSeasonId(int seasonId) {
	this.seasonId = seasonId;
}
/**
 * @return the survivorId
 */
public int getSurvivorId() {
	return survivorId;
}
/**
 * @param survivorId the survivorId to set
 */
public void setSurvivorId(int survivorId) {
	this.survivorId = survivorId;
}
/**
 * @return the dayVotedOut
 */
public int getDayVotedOut() {
	return dayVotedOut;
}
/**
 * @param dayVotedOut the dayVotedOut to set
 */
public void setDayVotedOut(int dayVotedOut) {
	this.dayVotedOut = dayVotedOut;
}
/**
 * @return the originalTribe
 */
public int getOriginalTribe() {
	return originalTribe;
}
/**
 * @param originalTribe the originalTribe to set
 */
public void setOriginalTribe(int originalTribe) {
	this.originalTribe = originalTribe;
}
/**
 * @return the currentTribe
 */
public int getCurrentTribe() {
	return currentTribe;
}
/**
 * @param currentTribe the currentTribe to set
 */
public void setCurrentTribe(int currentTribe) {
	this.currentTribe = currentTribe;
}
/**
 * @return the secondTribe
 */
public int getSecondTribe() {
	return secondTribe;
}
/**
 * @param secondTribe the secondTribe to set
 */
public void setSecondTribe(int secondTribe) {
	this.secondTribe = secondTribe;
}
/**
 * @return the thirdTribe
 */
public int getThirdTribe() {
	return thirdTribe;
}
/**
 * @param thirdTribe the thirdTribe to set
 */
public void setThirdTribe(int thirdTribe) {
	this.thirdTribe = thirdTribe;
}
/**
 * @return the fourthTribe
 */
public int getFourthTribe() {
	return fourthTribe;
}
/**
 * @param fourthTribe the fourthTribe to set
 */
public void setFourthTribe(int fourthTribe) {
	this.fourthTribe = fourthTribe;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "CastMember [seasonId=" + seasonId + ", survivorId=" + survivorId + ", dayVotedOut=" + dayVotedOut
			+ ", originalTribe=" + originalTribe + ", currentTribe=" + currentTribe + ", secondTribe=" + secondTribe
			+ ", thirdTribe=" + thirdTribe + ", fourthTribe=" + fourthTribe + ", getSeasonId()=" + getSeasonId()
			+ ", getSurvivorId()=" + getSurvivorId() + ", getDayVotedOut()=" + getDayVotedOut()
			+ ", getOriginalTribe()=" + getOriginalTribe() + ", getCurrentTribe()=" + getCurrentTribe()
			+ ", getSecondTribe()=" + getSecondTribe() + ", getThirdTribe()=" + getThirdTribe() + ", getFourthTribe()="
			+ getFourthTribe() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + currentTribe;
	result = prime * result + dayVotedOut;
	result = prime * result + fourthTribe;
	result = prime * result + originalTribe;
	result = prime * result + seasonId;
	result = prime * result + secondTribe;
	result = prime * result + survivorId;
	result = prime * result + thirdTribe;
	return result;
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
	CastMember other = (CastMember) obj;
	if (currentTribe != other.currentTribe)
		return false;
	if (dayVotedOut != other.dayVotedOut)
		return false;
	if (fourthTribe != other.fourthTribe)
		return false;
	if (originalTribe != other.originalTribe)
		return false;
	if (seasonId != other.seasonId)
		return false;
	if (secondTribe != other.secondTribe)
		return false;
	if (survivorId != other.survivorId)
		return false;
	if (thirdTribe != other.thirdTribe)
		return false;
	return true;
}



}
