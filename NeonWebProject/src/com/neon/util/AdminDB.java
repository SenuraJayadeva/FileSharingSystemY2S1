package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.Admin;




public class AdminDB {
	
	
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";

	public static String getAdminImagePath(String loginID) throws ClassNotFoundException, SQLException{
		
		
		Admin admin = new Admin();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from admin where email = '"+ loginID + "' ");
		
		while(rs.next()) {
			
			String fileName = rs.getString(6);// the column in which the path is stored
			admin.setFileName(fileName);
		}
	
		
		
			return admin.getFileName();
		
		
		
	}
	
public static List<Admin> getAdminList(String loginID) throws ClassNotFoundException, SQLException{
		
		
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from admin where email = '"+ loginID + "' ");
		
		while(rs.next()) {
			String adminID = rs.getString(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String pwd = rs.getString(5);
			String fileName = rs.getString(6);
			String path = rs.getString(7);
			
			Admin adm = new Admin(adminID,firstName,lastName,email,pwd,fileName,path);
			admin.add(adm);
		}
		
		return admin;
		
	}
}
