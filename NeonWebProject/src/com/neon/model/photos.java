package com.neon.model;

public class photos extends File {
	
	
	private String photoID;
	
	public photos() {
		super();
	}
	
	
	public photos(String photoID, String userID, String name, String description, String filename, String path) {
		
		super(userID, name, description, filename, path);
		
		this.photoID = photoID;
		
	}

	public String getPhotoID() {
		return photoID;
	}

	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}


}
