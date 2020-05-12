package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.Document;




public class uploadDAO {

	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	
	public static List<Document> getDocumentlist(String userID) throws ClassNotFoundException,SQLException{
		
		ArrayList<Document> document = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
				
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from documentdb where userId = '"+userID+"' ");
		
		while(result.next()) {
			String docId = result.getString(1);
			String userEmail = result.getString(2);
			String name = result.getString(3);
			String description = result.getString(4);
			String filename = result.getString(5);
			String path = result.getString(6);
			
			Document doc = new Document(docId,userEmail,name,description,filename,path);
			document.add(doc);
			
		}
				
		
		return document;
	}
	
	public static List<Document> getDocumentDetails(String docID) throws ClassNotFoundException,SQLException{
		
		ArrayList<Document> document = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
				
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from documentdb where docId = '"+docID+"' ");
		
		while(result.next()) {
			String docId = result.getString(1);
			String userEmail = result.getString(2);
			String name = result.getString(3);
			String description = result.getString(4);
			String filename = result.getString(5);
			String path = result.getString(6);
			
			Document doc = new Document(docId,userEmail,name,description,filename,path);
			document.add(doc);
			
		}
				
		
		return document;
	}
	
	public static List<Document> getDocumentListToShare(String shareDocId) throws ClassNotFoundException,SQLException{
		
		ArrayList<Document> document = new ArrayList<>();
		
		//load the mysql Driver
				Class.forName("com.mysql.jdbc.Driver");
						
				//get the connection
				Connection con = DriverManager.getConnection(url, userName, password);
				
				//create statement
				Statement stmt = con.createStatement();
				
				ResultSet result = stmt.executeQuery("select * from documentdb where docId = '"+shareDocId+"' ");
		
				while(result.next()) {
					String docId = result.getString(1);
					String userEmail = result.getString(2);
					String name = result.getString(3);
					String description = result.getString(4);
					String filename = result.getString(5);
					String path = result.getString(6);
					
					Document doc = new Document(docId,userEmail,name,description,filename,path);
					document.add(doc);
					
				}
				return document;
		
	}
	
public void insertDocument(Document document) throws ClassNotFoundException, SQLException {
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
	
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//sql query to insert data
		PreparedStatement prep = con.prepareStatement("insert into documentdb (userId,name,description,filename,path) values(?,?,?,?,?)");
		
		

		//assign variables to database attributes
		prep.setString(1, document.getUserID());
		prep.setString(2, document.getName());
		prep.setString(3, document.getDescription());
		prep.setString(4, document.getFilename());
		prep.setString(5, document.getPath());
		
	
		
		//execute query
		prep.executeUpdate();
		
		
		
	}
	
	public void deleteDocument(Document document) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement stmt = con.createStatement(); 
		
	   stmt.executeUpdate("delete from documentdb where docId='"+document.getDocId()+"'  ");
		
		
	}
	
	
	
	public void UpdateDocumentDetails(Document document) throws ClassNotFoundException, SQLException {
		
		
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update documentdb set name = ?, description = ? where docID = ? ");
		
		ps.setString(1, document.getName());
		ps.setString(2, document.getDescription());
		ps.setString(3, document.getDocId());
		
		ps.executeUpdate();
		
	}
	
	
	
}
