package com.neon.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.contactDetails;
import com.neon.util.contactDAO;



@WebServlet("/Contact_us")
public class Contact_us extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    contactDAO contactdao = new contactDAO();
		   
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Message = request.getParameter("Message");
		String Feedback = request.getParameter("Feedback");
		
		contactDetails contact = new contactDetails();
		contact.setName(Name);
		contact.setEmail(Email);
		contact.setMessage(Message);
		contact.setFeedback(Feedback);
		
		try {
		contactdao.contactForm(contact);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*response.sendRedirect("user");*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Contact.jsp");
		dispatcher.forward(request, response);
		
	}

}
