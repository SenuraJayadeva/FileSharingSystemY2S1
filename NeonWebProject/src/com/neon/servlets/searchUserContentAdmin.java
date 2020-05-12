package com.neon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.util.CustomerDB;

//servlet mapping
@WebServlet("/searchUserContentAdmin")
public class searchUserContentAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//creating a variable of type string and initializing with the parameter send using the search box
		String SearchuserMail = request.getParameter("searchEmail");
//creating an instance of customer DB 	
		CustomerDB cusDB = new CustomerDB();
		
		try {
//validating whether the customer is in the database			
			boolean validate = cusDB.checkUser(SearchuserMail);
			
			if(validate == true) {
//getting the session variable and assigning the customer ID			
				HttpSession session = request.getSession();
				session.setAttribute("searchID", request.getParameter("searchEmail"));
//redirect			
				response.sendRedirect("adminEditContent.jsp");
				
			}else {			
				
				response.sendRedirect("adminEditContent.jsp");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
//exception handling			
			PrintWriter writer = response.getWriter();

			writer.print("Error exception");
			e.printStackTrace();
		}
	}

}
