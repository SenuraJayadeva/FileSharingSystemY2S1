package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neon.model.Login;



public class LoginDBAdmin {
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	public boolean adminLog(Login log) throws ClassNotFoundException, SQLException {
		//mysql drivers loading
		
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			Connection con = DriverManager.getConnection(url,userName ,password);
			
			ResultSet result = con.createStatement().executeQuery("select * from admin where email = '"+log.getEmail()+"' and password='"+log.getPassword()+"' ");
	
			if(result.next()) {
				return true;
			
			}
			else {
				
				return false;
			}
			
	}
}
