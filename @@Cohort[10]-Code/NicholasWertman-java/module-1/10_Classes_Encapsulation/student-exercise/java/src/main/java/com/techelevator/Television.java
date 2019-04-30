package com.techelevator;

public class Television {

	private boolean isOn;
	private int currentChannel;
	private int currentVolume;

	public Television() {
		this.isOn = false;
		this.currentChannel = 3;
		this.currentVolume = 2;
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

	public boolean isOn() {
		return isOn;
	}

	public void turnOff() {
		isOn = false;
	}

	public void turnOn() {
		isOn = true;
	}

	public void changeChannel(int newChannel) {
		if (isOn == true) {
		currentChannel = newChannel;
		}
	}

	public void channelUp() {
		if (isOn == true && currentChannel < 18) {
			currentChannel += 1;
		}
		else if (isOn == true && currentChannel == 18) {
			currentChannel = 3;
		}
	}

	public void channelDown() {
		if (isOn == true && currentChannel >= 4) {
			currentChannel -= 1;
		}
		else if (isOn == true && currentChannel == 3) {
			currentChannel = 18;
		}
	}

	public void raiseVolume() {
		if (isOn == true) {
			currentVolume += 1;
		}
	}

	public void lowerVolume() {
		if (isOn == true && currentVolume > 0) {
			currentVolume -= 1;
		}
	}
}
