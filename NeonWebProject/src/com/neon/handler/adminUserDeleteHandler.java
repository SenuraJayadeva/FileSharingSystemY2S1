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

import com.neon.model.Customer;
import com.neon.util.CustomerDB;

@WebServlet("/adminUserDeleteHandler")
public class adminUserDeleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
try {
			
			
		List<Customer> customerDeatils  = CustomerDB.getCustomerList();
		request.setAttribute("customerDetails", customerDeatils);
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//redirect to a different page(view)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminDeleteUser.jsp");	
		requestDispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
