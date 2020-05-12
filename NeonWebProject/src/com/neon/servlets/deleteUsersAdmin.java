package com.neon.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.Customer;
import com.neon.util.CustomerDB;

//servlet mapping
@WebServlet("/deleteUserAdmin")
public class deleteUsersAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//creating an instance of type customer
		Customer cus = new Customer();
//assigning the ID  		
		cus.setUserID(request.getParameter("userID"));
		
		
		
		
		CustomerDB cusDB = new CustomerDB();
		
		
		try {
			PrintWriter pw = response.getWriter();
			pw.println(request.getParameter("userID"));	
//deleting the customer withe the relevant user ID using the method of the instance created from class CustomerDB
			cusDB.deleteCustomer(cus.getUserID());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//redirecting		
		response.sendRedirect("adminDeleteUser.jsp");	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
