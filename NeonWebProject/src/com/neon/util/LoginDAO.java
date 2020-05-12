package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neon.model.Login;

public class LoginDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	public boolean userLogin(Login login) throws ClassNotFoundException, SQLException {
		
				//load the mysql Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//get the connection
				Connection con = DriverManager.getConnection(url, userName, password);
				
				//create statement
				Statement stmt = con.createStatement();
				
				//execute the satement and loop over the result set
				ResultSet rs = stmt.executeQuery("select * from user where email = '"+login.getEmail()+"' and password='"+login.getPassword()+"' ");
		
				if(rs.next()) {
					
					return true;
					
				}else {
					return false;
				}
				
	}

}
