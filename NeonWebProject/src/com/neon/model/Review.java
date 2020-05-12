package com.neon.model;

public class Review {

	private String Name;
	private String Country;
	private String Email;
	private String message;
	private String rating;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Review(String name, String country, String email, String message, String rating) {
		super();
		Name = name;
		Country = country;
		Email = email;
		this.message = message;
		this.rating = rating;
	}
	public Review() {
		super();

	}
	
	
}
