package com.neon.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neon.model.Review;



public class ReviewDB {
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	
public void insertReview(Review rev) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into review(name,Country,email,message,rating) values(?,?,?,?,?)");
		
		ps.setString(1, rev.getName());
		ps.setString(2, rev.getCountry());
		ps.setString(3, rev.getEmail());
		ps.setString(4, rev.getMessage());
		ps.setString(5, rev.getRating());
		
		
		ps.executeUpdate();
		
	}


	public static List<Review> getReview() throws SQLException, ClassNotFoundException{
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		ArrayList<Review> rev = new ArrayList<>();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from review");
			
			while(rs.next()) {
				String name = rs.getString(1);
				String Country = rs.getString(2);
				String email = rs.getString(3);
				String message = rs.getString(4);
				String rating = rs.getString(5);

				
				Review review = new Review(name,Country,email,message,rating);
				rev.add(review);
			}
			
			return rev;
			
		
	}
}
