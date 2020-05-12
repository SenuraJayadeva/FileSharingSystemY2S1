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

import com.neon.model.Login;

import com.neon.util.CustomerDB;
import com.neon.util.LoginDAO;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

       

    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Login login = new Login();
		
		PrintWriter writer = response.getWriter();
		
		login.setEmail(request.getParameter("userName"));
		login.setPassword(request.getParameter("password"));
		
		LoginDAO checkUserLogin = new LoginDAO();
		try {
			boolean validate = checkUserLogin.userLogin(login);
			
			if(validate == true) {
			
				HttpSession session = request.getSession();
				session.setAttribute("userName", request.getParameter("userName"));
				session.setAttribute("password", request.getParameter("password"));
			    
				String fileName =  CustomerDB.getCustomerImagePath(request.getParameter("userName"));
				session.setAttribute("path", fileName);
				
			
				response.sendRedirect("user");
				
			}else {			
				
				response.sendRedirect("login.jsp");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			writer.print("Error exception");
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
