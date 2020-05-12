package com.neon.model;

public class Person {
	
	
	protected String FirstName;
	
	protected String LastName;
	
	protected String email;
	
	protected String password;
	
	protected String fileName;
	
	protected String Path;

	public Person() {
		super();
	}


	//overloaded constructor
	public Person(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	//overloaded constructor
	public Person(String firstName, String lastName, String email, String password, String fileName, String path) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.fileName = fileName;
		Path = path;
	}
		

	// setters and getters
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	
}
