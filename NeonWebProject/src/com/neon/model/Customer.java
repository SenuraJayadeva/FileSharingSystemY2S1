package com.neon.model;


public class Customer extends Person {

	private String userID;

	
	public Customer() {
		super();
	}
	
	public Customer(String email, String password) {
		super(email, password);
		
	}
	
  
	public Customer(String firstName, String lastName, String email, String password, String fileName, String path) {
		
		//call the overloaded method of Person class
		super(firstName, lastName, email, password, fileName, path);
		
	}

	public Customer(String userID, String firstName, String lastName, String email, String password, String fileName, String path) {
		
		//call the overloaded method of Person class
		super(firstName, lastName, email, password, fileName, path);
		
		this.userID = userID;
	}
	
	
	//setters and getters
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	

	


}
