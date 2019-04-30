package com.techelevator;

public class Television {
	
private boolean isOn = false;
private int currentChannel = 3;
private int currentVolume = 2;

public void turnOff() {
	isOn = false;
}

public void turnOn() {
	isOn = true;
}

public void changeChannel(int newChannel) {
	if(isOn) {
		if(newChannel >= 3 && newChannel <= 18) {
			currentChannel = newChannel;
		}
	}
}

public void channelUp() {
	if(isOn) {
		currentChannel += 1;
		if(currentChannel > 18) {
			currentChannel = 3;
		}
	}
}

public void channelDown() {
	if(isOn) {
		currentChannel -= 1;
		if(currentChannel < 3) {
			currentChannel = 18;
		}
	}
}

public void raiseVolume() {
	if(isOn) {
		currentVolume += 1;
		if(currentVolume > 10) {
			currentVolume = 10;
		}
	}
	
}

public void lowerVolume() {
	if(isOn) {
		currentVolume -= 1;
		if(currentVolume < 1) {
			currentVolume = 0;
		}
	}
	
}




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




}
