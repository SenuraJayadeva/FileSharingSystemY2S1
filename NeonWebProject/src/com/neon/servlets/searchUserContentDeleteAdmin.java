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

@WebServlet("/searchUserContentDeleteAdmin")
public class searchUserContentDeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public searchUserContentDeleteAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating a variable of type string and initializing with the parameter send using the search box
		String SearchuserID = request.getParameter("searchEmail");
		//creating an instance of customer DB 	
		
		CustomerDB cusDB = new CustomerDB();
		

		PrintWriter out = response.getWriter();
		out.println(SearchuserID);
		
		try {
			boolean validate = cusDB.checkUser(SearchuserID);
			
			if(validate == true) {
				//getting the session variable and assigning the customer ID			
				HttpSession session = request.getSession();
				session.setAttribute("searchID", request.getParameter("searchEmail"));
				//redirect	
				response.sendRedirect("adminDeleteContent.jsp");
				
			}else {			
				
				response.sendRedirect("adminDeleteContent.jsp");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			PrintWriter writer = response.getWriter();

			writer.print("Error exception");
			e.printStackTrace();
		}
	}
}
