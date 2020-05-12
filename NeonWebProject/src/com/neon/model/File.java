package com.neon.model;


//File Class
public class File {
	
	protected String userID;
	
	protected String name;
	
	protected String description;
	
	protected String filename;
	
	protected String path;
	
	//Constructor
	public File() {
		super();
	}

	//overloaded constructor
	public File(String userID, String name, String description, String filename, String path) {
		super();
		this.userID = userID;
		this.name = name;
		this.description = description;
		this.filename = filename;
		this.path = path;
	}

    //setters and getters for attributes
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
