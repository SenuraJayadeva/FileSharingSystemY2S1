package com.neon.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neon.model.Customer;
import com.neon.model.Login;
import com.neon.util.CustomerDB;
import com.neon.util.LoginDBAdmin;


@WebServlet("/updateUserDetails")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
								maxFileSize = 1024 * 1024 * 10, //10MB
								maxRequestSize = 1024 * 1024 * 50)

public class updateUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		
		Customer customer = new Customer();
		
		customer.setEmail(request.getParameter("Email"));
		customer.setFirstName(request.getParameter("FirstName"));
		customer.setLastName(request.getParameter("LastName"));
		customer.setPassword(request.getParameter("NewPassword"));

			
			PrintWriter writer = response.getWriter();
			
			writer.print (request.getParameter("Email"));
			writer.print (request.getParameter("FirstName"));
			writer.print (request.getParameter("LastName"));
			writer.print (request.getParameter("NewPassword"));
			
			
			CustomerDB update = new CustomerDB();
			
			try {
				
				update.updateUserDetails(customer);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
			
			Login log = new Login();
			
			HttpSession session = request.getSession();
			
			log.setEmail((String) session.getAttribute("userName"));
			log.setPassword((String) session.getAttribute("password"));
			LoginDBAdmin checkCredentials = new LoginDBAdmin();
			try {
				
				boolean res = checkCredentials.adminLog(log);
				if(res == true ) {
					
					
					response.sendRedirect("adminEditContent.jsp");
					
				}else {
					
					response.sendRedirect("user");

				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}

	
}
