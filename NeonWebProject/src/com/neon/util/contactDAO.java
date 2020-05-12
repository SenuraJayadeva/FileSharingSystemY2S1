package com.neon.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neon.model.contactDetails;

public class contactDAO {
	
	//create database connection
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";

	public void contactForm(contactDetails contact) throws ClassNotFoundException, SQLException{
		
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
						
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//sql query to insert data to activity database
		PreparedStatement prepStatemnt = con.prepareStatement("insert into contactform(Name,Email,Message,Feedback) values(?,?,?,?)");
		
		prepStatemnt.setString(1,contact.getName());
		prepStatemnt.setString(2,contact.getEmail());
		prepStatemnt.setString(3,contact.getMessage());
		prepStatemnt.setString(4,contact.getFeedback());
			
		
		//execute or update the query
			
		prepStatemnt.executeUpdate();
			
			
		
	}
	
}
