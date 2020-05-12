package com.neon.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Admin;
import com.neon.util.AdminDB;




@WebServlet("/adminHandler")
public class adminHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
				
				try {
					
					List<Admin> adminDeatils  = AdminDB.getAdminList(userName);
					request.setAttribute("adminDetails", adminDeatils);
					
					
					
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();

				}
				
				//redirect to a differnt page(view)
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminDeleteCintent.jsp");	
				requestDispatcher.forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
