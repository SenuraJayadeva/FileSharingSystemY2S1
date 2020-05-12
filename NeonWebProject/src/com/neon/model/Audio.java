package com.neon.model;

public class Audio extends File {
	
	private String audioID;
	
    
	public Audio() {
		super();
	}
	
	
	public Audio(String audioID, String userID, String name, String description, String filename, String path) {
		
		// call the overloaded method in File Class
		super(userID, name, description, filename, path); 
		
		this.audioID = audioID;
		
	}

	//setters and getters
	
	public String getAudioID() {
		return audioID;
	}

	public void setAudioID(String audioID) {
		this.audioID = audioID;
	}



}
