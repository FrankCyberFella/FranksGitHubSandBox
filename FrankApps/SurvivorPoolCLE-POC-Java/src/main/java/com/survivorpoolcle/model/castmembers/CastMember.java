package com.survivorpoolcle.model.castmembers;

public class CastMember {
private int seasonid;
private int survivorid;
private int dayvotedout;
private String originaltribe;
private String currenttribe;
private String secondtribe;
private String thirdtribe;
private String fourthtribe;

/**

 */
public CastMember() {

}
/**
 * @param seasonid
 * @param survivorid
 */
public CastMember(int seasonid, int survivorid) {
	this.seasonid = seasonid;
	this.survivorid = survivorid;
}
/**
 * @return the seasonid
 */
public int getSeasonid() {
	return seasonid;
}
/**
 * @param seasonid the seasonid to set
 */
public void setSeasonid(int seasonid) {
	this.seasonid = seasonid;
}
/**
 * @return the survivorid
 */
public int getSurvivorid() {
	return survivorid;
}
/**
 * @param survivorid the survivorid to set
 */
public void setSurvivorid(int survivorid) {
	this.survivorid = survivorid;
}
/**
 * @return the dayvotedout
 */
public int getDayvotedout() {
	return dayvotedout;
}
/**
 * @param dayvotedout the dayvotedout to set
 */
public void setDayvotedout(int dayvotedout) {
	this.dayvotedout = dayvotedout;
}
/**
 * @return the originaltribe
 */
public String getOriginaltribe() {
	return originaltribe;
}
/**
 * @param originaltribe the originaltribe to set
 */
public void setOriginaltribe(String originaltribe) {
	this.originaltribe = originaltribe;
}
/**
 * @return the currenttribe
 */
public String getCurrenttribe() {
	return currenttribe;
}
/**
 * @param currenttribe the currenttribe to set
 */
public void setCurrenttribe(String currenttribe) {
	this.currenttribe = currenttribe;
}
/**
 * @return the secondtribe
 */
public String getSecondtribe() {
	return secondtribe;
}
/**
 * @param secondtribe the secondtribe to set
 */
public void setSecondtribe(String secondtribe) {
	this.secondtribe = secondtribe;
}
/**
 * @return the thirdtribe
 */
public String getThirdtribe() {
	return thirdtribe;
}
/**
 * @param thirdtribe the thirdtribe to set
 */
public void setThirdtribe(String thirdtribe) {
	this.thirdtribe = thirdtribe;
}
/**
 * @return the fourthtribe
 */
public String getFourthtribe() {
	return fourthtribe;
}
/**
 * @param fourthtribe the fourthtribe to set
 */
public void setFourthtribe(String fourthtribe) {
	this.fourthtribe = fourthtribe;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "CastMembers [seasonid=" + seasonid + ", survivorid=" + survivorid + ", dayvotedout=" + dayvotedout
			+ ", originaltribe=" + originaltribe + ", currenttribe=" + currenttribe + ", secondtribe=" + secondtribe
			+ ", thirdtribe=" + thirdtribe + ", fourthtribe=" + fourthtribe + ", getSeasonid()=" + getSeasonid()
			+ ", getSurvivorid()=" + getSurvivorid() + ", getDayvotedout()=" + getDayvotedout()
			+ ", getOriginaltribe()=" + getOriginaltribe() + ", getCurrenttribe()=" + getCurrenttribe()
			+ ", getSecondtribe()=" + getSecondtribe() + ", getThirdtribe()=" + getThirdtribe() + ", getFourthtribe()="
			+ getFourthtribe() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((currenttribe == null) ? 0 : currenttribe.hashCode());
	result = prime * result + dayvotedout;
	result = prime * result + ((fourthtribe == null) ? 0 : fourthtribe.hashCode());
	result = prime * result + ((originaltribe == null) ? 0 : originaltribe.hashCode());
	result = prime * result + seasonid;
	result = prime * result + ((secondtribe == null) ? 0 : secondtribe.hashCode());
	result = prime * result + survivorid;
	result = prime * result + ((thirdtribe == null) ? 0 : thirdtribe.hashCode());
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
	if (currenttribe == null) {
		if (other.currenttribe != null)
			return false;
	} else if (!currenttribe.equals(other.currenttribe))
		return false;
	if (dayvotedout != other.dayvotedout)
		return false;
	if (fourthtribe == null) {
		if (other.fourthtribe != null)
			return false;
	} else if (!fourthtribe.equals(other.fourthtribe))
		return false;
	if (originaltribe == null) {
		if (other.originaltribe != null)
			return false;
	} else if (!originaltribe.equals(other.originaltribe))
		return false;
	if (seasonid != other.seasonid)
		return false;
	if (secondtribe == null) {
		if (other.secondtribe != null)
			return false;
	} else if (!secondtribe.equals(other.secondtribe))
		return false;
	if (survivorid != other.survivorid)
		return false;
	if (thirdtribe == null) {
		if (other.thirdtribe != null)
			return false;
	} else if (!thirdtribe.equals(other.thirdtribe))
		return false;
	return true;
}
}
