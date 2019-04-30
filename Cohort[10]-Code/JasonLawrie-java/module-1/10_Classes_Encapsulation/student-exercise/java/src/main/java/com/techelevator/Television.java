package com.techelevator;

public class Television {
	private boolean isOn=false;
	private int currentChannel=3;
	private int currentVolume=2;
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
		isOn=false;
	}
	public void turnOn() {
		currentChannel=3;
		currentVolume=2;
		isOn=true;
	}
	public void changeChannel(int newChannel) {
		if(isOn&&newChannel>=3&&newChannel<=18) {
			this.currentChannel=newChannel;
		}
		
	}
	public void channelUp() {
		if(isOn) {
			currentChannel++;
			if(currentChannel>18) {
				currentChannel=3;
			}
		}
		
	}
	public void channelDown() {
		if(isOn) {
			currentChannel--;
			if(currentChannel<3) {
				currentChannel=18;
			}
		}
		
	}
	public void raiseVolume() {
		if(isOn&&currentVolume!=10) {
			currentVolume++;
		}
		
	}
	public void lowerVolume() {
		if(isOn&&currentVolume!=0) {
			currentVolume--;
		}
		
	}
}