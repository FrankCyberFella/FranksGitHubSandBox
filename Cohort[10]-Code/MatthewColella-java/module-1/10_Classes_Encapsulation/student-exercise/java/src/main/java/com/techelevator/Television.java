package com.techelevator;

public class Television {

	private boolean isOn;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	public Television(){
		
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
		 if(isOn == true && currentChannel == 18) {
			 currentChannel = 3;
		 }
		 else if(isOn == true && currentChannel >= 3 && currentChannel < 18) {
			 currentChannel ++;
		 }
		 
	 }
	public void channelDown() {
		 if(isOn == true && currentChannel == 3) {
			 currentChannel = 18;
		 }
		 else if(isOn == true && currentChannel > 3 && currentChannel <= 18) {
			 currentChannel --;
		 }
		 
	 }
	public void raiseVolume() {
		 if(isOn && currentVolume >= 1 && currentVolume <= 10) {
			 currentVolume ++;
		 }
		 
	 }
	public void lowerVolume() {
		 if(isOn && currentVolume >= 1 && currentVolume <= 10) {
			 currentVolume --;
		 
		 }
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
	
}