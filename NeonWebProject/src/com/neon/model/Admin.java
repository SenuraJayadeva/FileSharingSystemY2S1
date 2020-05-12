package com.neon.model;

public class Admin extends Person {
	
	private String adminID;
	

	public Admin() {
		super();
	}


   

	public Admin(String adminID, String firstName, String lastName, String email, String password, String fileName, String path) {
		super(firstName, lastName, email, password, fileName, path);
		
		this.adminID = adminID;
	}

	
	public Admin(String email, String password) {
		
		super(email, password);
		
	}

    

	public Admin(String firstName, String lastName, String email, String password, String fileName, String path) {
		
		super(firstName, lastName, email, password, fileName, path);
	
	}




	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}



}
