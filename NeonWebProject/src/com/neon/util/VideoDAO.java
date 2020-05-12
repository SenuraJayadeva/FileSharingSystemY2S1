package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.Video;

public class VideoDAO {

	
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";

	
	public static List<Video> getVideoList(String userID) throws ClassNotFoundException, SQLException{
		
		ArrayList<Video> video = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from videodatabase where userEmail = '"+userID+"' ");
		
		
		while(rs.next()) {
			String videoID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Video vid = new Video(videoID,userEmail,name,description,fileName,path);
			video.add(vid);
		}
		
		return video; 
		
		
	}
	
	
	public static List<Video> getVideoListToShare(String shareVideoID) throws ClassNotFoundException, SQLException{
		
		ArrayList<Video> video = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from videodatabase where videoID = '"+shareVideoID+"' ");
		
		
		while(rs.next()) {
			String videoID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Video vid = new Video(videoID,userEmail,name,description,fileName,path);
			video.add(vid);
		}
		
		return video; 
		
		
	}
	
	
	public void insertVideo(Video video) throws ClassNotFoundException, SQLException {
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("insert into videodatabase(userEmail,name,description,filename,path) values(?,?,?,?,?)");
		
		

		//assign variables to database attributes
		ps.setString(1, video.getUserID());
		ps.setString(2, video.getName());
		ps.setString(3, video.getDescription());
		ps.setString(4, video.getFilename());
		ps.setString(5, video.getPath());
		
	
		
		//execute query
		ps.executeUpdate();
		
		
		
	}
	
	public void deleteVideo(Video video) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
	   statement.executeUpdate("delete from videodatabase where videoID='"+video.getVideoID()+"'   ");
		
		
	}
	
	
public void UpdateVideoDetails(Video video) throws ClassNotFoundException, SQLException {
		
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update videodatabase set name = ?, description = ? where videoID = ? ");
		
		ps.setString(1, video.getName());
		ps.setString(2, video.getDescription());
		ps.setString(3, video.getVideoID());
		
		ps.executeUpdate();
		
	}


}
