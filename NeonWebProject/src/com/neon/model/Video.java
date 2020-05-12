package com.neon.model;

public class Video extends File {
	
	private String videoID;
	
	
	public Video() {
		super();
	}
   
	//overloaded constructor
	public Video(String videoID, String userID, String name, String description, String filename, String path) {
		
		super(userID, name, description, filename, path);
		
		this.videoID = videoID; 
		
		
	}

   //setters and getters
	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}



}
