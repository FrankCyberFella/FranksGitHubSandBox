package com.techelevator.site;

public class Site {
	
	private long siteId;
	private long campId;
	private long siteNum;
	private int maxOccupancy;
	private boolean isAccessible;
	private int maxRvLength;
	private boolean hasUtil;
	
	
	
	public long getSiteId() {
		return siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	public long getCampId() {
		return campId;
	}
	public void setCampId(long campId) {
		this.campId = campId;
	}
	public long getSiteNum() {
		return siteNum;
	}
	public void setSiteNum(long siteNum) {
		this.siteNum = siteNum;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public boolean isAccessible() {
		return isAccessible;
	}
	public void setAccessible(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}
	public int getMaxRvLength() {
		return maxRvLength;
	}
	public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public boolean isHasUtil() {
		return hasUtil;
	}
	public void setHasUtil(boolean hasUtil) {
		this.hasUtil = hasUtil;
	}

}
