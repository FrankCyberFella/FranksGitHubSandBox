package com.techelevator;

public class Television {// Will need help with completing 

	// VARIABLES OR DATA MEMBERS
	private boolean isOn; // True tv is on and false tv is off.
	private int currentChannel;
	private int currentVolume;

	// CONSTRUCTORS // The Television class does not need a constructor. It can use
	// the default constructor.

	/*
	 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
	 * private variabless to be set to a given value and retrive that value when
	 * used
	 */
	public boolean isOn() {
		return isOn;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	// METHODSS
	public void turnOff() {
		isOn = false;
	}

	public void turnOn() {
		isOn = true;
		currentChannel = 3;
		currentVolume = 2;
	}

	public void changeChannel(int newChannel) {
		if (isOn && (newChannel >= 3 && newChannel <= 18)) {
			currentChannel = newChannel;
		}
	}

	public void channelUp() {
		if (isOn) {
			if (currentChannel < 18) {
				currentChannel += 1;
			} else {
				currentChannel = 3;
			}
		}
	}

	public void channelDown() {
		if (isOn) {
			if (currentChannel > 3) {
				currentChannel -= 1;
			} else {
				currentChannel = 18;
			}
		}
	}

	public void raiseVolume() {
		if (isOn) {
			if(currentVolume < 10) {
				currentVolume += 1;
			}	
		}
	}

	public void lowerVolume() {
		if (isOn) {
			if(currentVolume > 0) {
				currentVolume -= 1;
			}

		}
	}

}
