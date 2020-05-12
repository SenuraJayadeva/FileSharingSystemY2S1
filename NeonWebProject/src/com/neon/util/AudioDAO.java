package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.Audio;


public class AudioDAO {
	

	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	

	
		
	public void insertAudio(Audio audio) throws ClassNotFoundException, SQLException {
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("insert into audiodatabase(userEmail,name,description,filename,path) values(?,?,?,?,?)");
		
		

		//assign variables to database attributes
		ps.setString(1, audio.getUserID());
		ps.setString(2, audio.getName());
		ps.setString(3, audio.getDescription());
		ps.setString(4, audio.getFilename());
		ps.setString(5, audio.getPath());
		
	
		
		//execute query
		ps.executeUpdate();
		
		
		
	}


	public void UpdateAudioDetails(Audio audio) throws ClassNotFoundException, SQLException {
		
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update audiodatabase set name = ?, description = ? where audioID = ? ");
		
		ps.setString(1, audio.getName());
		ps.setString(2, audio.getDescription());
		ps.setString(3, audio.getAudioID());
		
		ps.executeUpdate();
		
	}
	
	
	public static  List<Audio> getAudioList(String userID) throws ClassNotFoundException, SQLException{
		
		ArrayList<Audio> audio = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from audiodatabase where userEmail = '"+userID+"' ");
		
		
		while(rs.next()) {
			String audioID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Audio aud = new Audio(audioID,userEmail,name,description,fileName,path);
			audio.add(aud);
		}
		
		return audio; 
		
		
	}
	
	
	public static List<Audio> getAudioListToShare(String shareAudioID) throws ClassNotFoundException, SQLException{
		
		ArrayList<Audio> audio = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from audiodatabase where audioID = '"+shareAudioID+"' ");
		
		
		while(rs.next()) {
			String audioID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Audio aud = new Audio(audioID,userEmail,name,description,fileName,path);
			audio.add(aud);
		}
		
		return audio; 
		
		
	}
	
	
	
	
	public  List<Audio> getAudioDetails(String audID) throws ClassNotFoundException, SQLException{
		
		ArrayList<Audio> audio = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from audiodatabase where audioID = '"+audID+"' ");
		
		
		while(rs.next()) {
			String audioID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Audio aud = new Audio(audioID,userEmail,name,description,fileName,path);
			audio.add(aud);
		}
		
		return audio; 
		
		
	}
	
	

	
	public void deleteAudio(Audio audio) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
	   statement.executeUpdate("delete from audiodatabase where audioID='"+audio.getAudioID()+"' ");
		
		
	}
	
	

	
	
	
	

}
