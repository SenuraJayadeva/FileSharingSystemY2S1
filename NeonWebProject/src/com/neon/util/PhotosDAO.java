package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.photos;

public class PhotosDAO {


	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
public static List<photos> getPhotoList(String userID) throws ClassNotFoundException, SQLException{
		
		ArrayList<photos> photo = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from photodatabase where userEmail = '"+userID+"' ");
		
		
		while(rs.next()) {
			String photoID = rs.getString(1);
			String userEmail = rs.getString(2);
			String name = rs.getString(3);
			String description = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			photos photos = new photos(photoID,userEmail,name,description,fileName,path);
			photo.add(photos);
		}
		
		return photo; 
		
		
	}



public static List<photos> getPhotoListToShare(String sharePhotoID) throws ClassNotFoundException, SQLException{
	
	ArrayList<photos> photo = new ArrayList<>();
	
	//load the mysql Driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//get the connection
	Connection con = DriverManager.getConnection(url, userName, password);
	
	//create statement
	Statement stmt = con.createStatement();
	
	//execute the satement and loop over the result set
	ResultSet rs = stmt.executeQuery("select * from photodatabase where photoID = '"+sharePhotoID+"' ");
	
	
	while(rs.next()) {
		String photoID = rs.getString(1);
		String userEmail = rs.getString(2);
		String name = rs.getString(3);
		String description = rs.getString(4);
		String fileName = rs.getString(5);
		String path = rs.getString(6);
		
		
		photos photos = new photos(photoID,userEmail,name,description,fileName,path);
		photo.add(photos);
	}
	
	return photo; 
	
	
}


public void insertPhotos(photos photo) throws ClassNotFoundException, SQLException {
	
	
	//load the mysql Driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//get the connection
	Connection con = DriverManager.getConnection(url, userName, password);
	
	//sql query to insert data
	PreparedStatement ps = con.prepareStatement("insert into photodatabase(userEmail,name,description,filename,path) values(?,?,?,?,?)");
	
	

	//assign variables to database attributes
	ps.setString(1, photo.getUserID());
	ps.setString(2, photo.getName());
	ps.setString(3, photo.getDescription());
	ps.setString(4, photo.getFilename());
	ps.setString(5, photo.getPath());
	

	
	//execute query
	ps.executeUpdate();
	
	
	
}

public void deletePhoto(photos photo) throws ClassNotFoundException, SQLException {
	
	//load the mysql Driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//get the connection
	Connection con = DriverManager.getConnection(url, userName, password);
	
	Statement statement = con.createStatement(); 
	
   statement.executeUpdate("delete from photodatabase where photoID='"+photo.getPhotoID()+"'  ");
	
	
}

public void UpdatePhotoDetails(photos photo) throws ClassNotFoundException, SQLException {
	
	
	
	//load the mysql Driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//get the connection
	Connection con = DriverManager.getConnection(url, userName, password);
		
	
	//sql query to insert data
	PreparedStatement ps = con.prepareStatement("update photodatabase set name = ?, description = ? where photoID = ? ");
	
	ps.setString(1, photo.getName());
	ps.setString(2, photo.getDescription());
	ps.setString(3, photo.getPhotoID());
	
	ps.executeUpdate();
	
}


}
