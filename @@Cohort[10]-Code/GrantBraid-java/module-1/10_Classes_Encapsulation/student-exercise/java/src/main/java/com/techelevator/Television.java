package com.techelevator;

public class Television {

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;
	/**
	 * @return the isOn
	 */
	public boolean isOn() {
		return isOn;
	}
	/**
	 * @return the currentChannel
	 */
	public int getCurrentChannel() {
		return currentChannel;
	}
	/**
	 * @return the currentVolume
	 */
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public void turnOff() {
		isOn = false;
	}
	
	public void turnOn() {
		isOn = true;
	}
	
	public void changeChannel(int newChannel) {
		if (isOn) {
			if (newChannel >= 3 && newChannel <= 18) {
				currentChannel = newChannel;
			}
	
		}
		
	}
	public void channelUp() {
		if (isOn) {
			if (currentChannel >= 3 && currentChannel <= 17) {
				currentChannel++;
			} else if(currentChannel == 18) {
				currentChannel = 3;
			}
		}
	}
	
	public void channelDown() {
		if (isOn) {
			if (currentChannel >= 4 && currentChannel <= 18) {
				currentChannel--;
			} else if (currentChannel ==3) {
				currentChannel = 18;
			}
		}
	}
	
	public void raiseVolume() {
		if (isOn) {
			if (currentVolume<= 9) {
				currentVolume++;
			}
		}
	}
	
	public void lowerVolume() {
		if (isOn) {
			if (currentVolume >= 1) {
				currentVolume--;
			}
		}
	}
	
}
