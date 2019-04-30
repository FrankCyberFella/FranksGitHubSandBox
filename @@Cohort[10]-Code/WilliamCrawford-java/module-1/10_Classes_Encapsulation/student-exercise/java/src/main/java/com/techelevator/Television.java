package com.techelevator;

public class Television {

	private boolean isOn;
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
		 currentChannel = 3;
		 currentVolume = 2;
	 }
	 public void changeChannel(int newChannel) {
		 if(isOn == true && newChannel >= 3 && newChannel <= 18) {
			 currentChannel = newChannel;
		 }
	 }
	 public void channelUp() {
		 if( isOn == true) {
			 currentChannel++;
		 }
		 if(isOn && currentChannel > 18) {
			 currentChannel = 3;
		 }
	 }
	 public void channelDown(){
		 if( isOn == true) {
			 currentChannel--;
		 }
		 if(isOn && currentChannel < 3) {
			 currentChannel = 18;
		 }
	 }
	 public void raiseVolume(){
		 if( isOn == true && currentVolume < 10) {
			 currentVolume++;
		 }
		
	 }
	 public void lowerVolume() {
		 if( isOn == true && currentVolume > 0) {
			 currentVolume--; 
	 }
	
	
	
	
	 }

}
