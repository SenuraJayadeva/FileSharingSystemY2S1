package com.neon.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.neon.model.Customer;
import com.neon.util.CustomerDB;

@WebServlet("/InsertCustomer")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class InsertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form
		response.setContentType("text/html;charset=UTF-8");
		Customer customer = new Customer();
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\Senura\\eclipse-workspace\\NeonWebProject\\WebContent\\images\\" + File.separator + fileName;
		part.write(savePath + File.separator); 
		
		//get parameters and assigned it to the set methods of Customer class
		customer.setFirstName(request.getParameter("firstName"));;
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setFileName(fileName);
		customer.setPath(savePath);
		
		
		
		CustomerDB cusDB = new CustomerDB();
		
		try {
			
			//call the insertCustomer method of CustomerDB class and send customer object of Customer class as a parameter	
			cusDB.insertCustomer(customer);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", request.getParameter("email"));
		session.setAttribute("loginPassword", request.getParameter("password"));
		session.setAttribute("path", fileName);
		
		response.sendRedirect("user");
		
		
	}
	
	//this is related to file path
	private String extractFileName(Part part) {

		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if(s.trim().startsWith("filename")) {
				
				return s.substring(s.indexOf("=") + 2,s.length() - 1);
				
			}
		}
		return "";
	}
	

}
