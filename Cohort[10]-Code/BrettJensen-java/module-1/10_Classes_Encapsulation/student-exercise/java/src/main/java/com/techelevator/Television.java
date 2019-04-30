package com.techelevator;

public class Television {
	
	private boolean isOn;
	private int currentChannel;
	private int currentVolume;
	
	public Television() {
		isOn = false;
		currentChannel = 3;
		currentVolume = 2;
	}
	
	public boolean isOn() {
		return isOn;
	}
	public int getCurrentChannel() {
		return currentChannel;
	}
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public void turnOff() {
		isOn = false;
	}
	public void turnOn() {
		isOn = true;
		currentChannel = 3;
		currentVolume = 2;
	}
	public void changeChannel(int newChannel) {
		if(isOn) {
			if(newChannel >= 3 && newChannel <= 18 && newChannel != currentChannel) {
				currentChannel = newChannel;
			}
		}
	}
	public void channelUp() {
		if(isOn) {
			if((currentChannel + 1) <= 18) {
				currentChannel++;
			} else {
				currentChannel = 3;
			}
		}
	}
	public void channelDown() {
		if(isOn) {
			if((currentChannel - 1) >= 3) {
				currentChannel--;
			} else {
				currentChannel = 18;
			}
		}
	}
	public void raiseVolume() {
		if(isOn) {
			if((currentVolume + 1) <= 10) {
				currentVolume++;
			}
		}
	}
	public void lowerVolume() {
		if(isOn) {
			if((currentVolume - 1) >= 0) {
				currentVolume--;
			}
		}
	}
	
	
}
