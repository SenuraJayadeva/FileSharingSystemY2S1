package com.neon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neon.model.Customer;

public class CustomerDB {
	
		
	private static String url = "jdbc:mysql://localhost:3306/neondatabase?serverTimezone=UTC";
	private static String userName = "neon";
	private static String password = "neon";
	
	public static  List<Customer> getCustomerList() throws ClassNotFoundException, SQLException{
		
		
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from user ");
		
		//fetch data 
		while(rs.next()) {
			String userID = rs.getString(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String pwd = rs.getString(5);
			String fileName = rs.getString(6);
			String path = rs.getString(7);
			
			Customer cus = new Customer(userID,firstName,lastName,email,pwd,fileName,path);
			customer.add(cus);
		}
		
		return customer;
		
	}
	
	public static  List<Customer> getCustomerList(String loginID) throws ClassNotFoundException, SQLException{
		
		
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from user where email = '"+ loginID + "' ");
		
		while(rs.next()) {
			String userID = rs.getString(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String pwd = rs.getString(5);
			String fileName = rs.getString(6);
			String path = rs.getString(7);
			
			Customer cus = new Customer(userID,firstName,lastName,email,pwd,fileName,path);
			customer.add(cus);
		}
		
		return customer;
		
	}
	
	
	
	public static String getCustomerImagePath(String loginID) throws ClassNotFoundException, SQLException{
		
	
		Customer customer = new Customer();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from user where email = '"+ loginID + "' ");
		
		while(rs.next()) {
			
			String fileName = rs.getString(6);
			customer.setFileName(fileName);
		}
	
		
		
			return customer.getFileName();
		
		
		
	}


	
	public void insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into user(firstName,lastName,email,password,filename,path) values(?,?,?,?,?,?)");
		
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getEmail());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getFileName());
		ps.setString(6, customer.getPath());
		
		
		ps.executeUpdate();
		
	}
	
	public void deleteCustomer(String UserID) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
	   statement.executeUpdate("delete from user where userID='"+UserID+"'   ");
	
	
	}
	
	public boolean checkUser(String UID) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//get the connection
				Connection con = DriverManager.getConnection(url, userName, password);
				
				//create statement
				Statement stmt = con.createStatement();
				
				//execute the satement and loop over the result set
				ResultSet rs = stmt.executeQuery("select * from user where email = '"+UID+"'  ");
		
				if(rs.next()) {
					
					return true;
					
				}else {
					return false;
				}
				
	}
	
	
	public void updateUserDetails(Customer customer) throws ClassNotFoundException,SQLException{
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		PreparedStatement stmt = con.prepareStatement("update user set firstName = ?,lastName = ?,password = ? where email = ?");
		
		stmt.setString(1, customer.getFirstName());
		stmt.setString(2, customer.getLastName());
		stmt.setString(3, customer.getPassword());
		stmt.setString(4, customer.getEmail());
		
		stmt.executeUpdate();
	}

	
	
	

}
