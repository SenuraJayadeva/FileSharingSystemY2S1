package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.ShareFiles;

public class ShareFilesDAO {
	
	
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	
		public void insertShareFile(ShareFiles sharefiles) throws ClassNotFoundException, SQLException {
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("insert into sharefilesdatabase(ReceivedUserEmail,FileID,FileType,senderUserID,SenderImagePath,name,description,filename,path) values(?,?,?,?,?,?,?,?,?)");
		

		//assign variables to database attributes
		ps.setString(1, sharefiles.getReceivedUserEmail());
		ps.setString(2, sharefiles.getFileID());
		ps.setString(3, sharefiles.getFileType());
		ps.setString(4, sharefiles.getSenderUserID());
		ps.setString(5, sharefiles.getSenderImagePath());
		ps.setString(6, sharefiles.getName());
		ps.setString(7, sharefiles.getDescription());
		ps.setString(8, sharefiles.getFilename());
		ps.setString(9, sharefiles.getPath());

		
		//execute query
		ps.executeUpdate();
	
		
		
	}
		
	
		public static  List<ShareFiles> getSharedFileList(String ReceivedUserID) throws ClassNotFoundException, SQLException{
			
			ArrayList<ShareFiles> shareFiles = new ArrayList<>();
			
			//load the mysql Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//get the connection
			Connection con = DriverManager.getConnection(url, userName, password);
			
			//create statement
			Statement stmt = con.createStatement();
			
			//execute the satement and loop over the result set
			ResultSet rs = stmt.executeQuery("select * from sharefilesdatabase where ReceivedUserEmail = '"+ReceivedUserID+"' ");
			
			
			while(rs.next()) {
				
				String shareID = rs.getString(1);
				String ReceivedUserEmail = rs.getString(2);
				String FileID = rs.getString(3);
				String FileType = rs.getString(4);
				String senderUserID = rs.getString(5);
				String SenderImagePath = rs.getString(6);
				String name = rs.getString(7);
				String description = rs.getString(8);
				String filename = rs.getString(9);
				String path = rs.getString(10);
				
				ShareFiles sf = new ShareFiles( shareID, ReceivedUserEmail,FileID,FileType,senderUserID,SenderImagePath,name,description,filename,path);
				shareFiles.add(sf);
			}
			
			return shareFiles; 
			
			
		}
		
		
		public void deleteSharedFiles(ShareFiles sharefiles) throws ClassNotFoundException, SQLException {
			
			//load the mysql Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//get the connection
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement statement = con.createStatement(); 
			
		   statement.executeUpdate("delete from sharefilesdatabase where shareID='"+sharefiles.getShareID()+"'   ");
			
			
		}
		

}
