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
import javax.servlet.http.Part;

import com.neon.model.Customer;
import com.neon.util.CustomerDB;
//servlet mapping
@WebServlet("/InsertCustomerAdmin")
//limiting the uploaded file size for picture
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
maxFileSize = 1024 * 1024 * 10, //10MB
maxRequestSize = 1024 * 1024 * 50)

public class InsertCustomerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InsertCustomerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		//creating an instance of type customer
		Customer customer = new Customer();
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\ASUS\\eclipse-workspace\\NeonWebProject\\WebContent\\images\\" + File.separator + fileName;
		part.write(savePath + File.separator); 

		//initializing the attributes of the customer object		
		customer.setFirstName(request.getParameter("firstName"));;
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setFileName(fileName);
		customer.setPath(savePath);
		
		
//creating an instance of the customer database		
		CustomerDB cusDB = new CustomerDB();
		
		try {
//passing the created object to the insertCustomer method of cusDB instance			
			cusDB.insertCustomer(customer);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//redirecting		
		response.sendRedirect("admin.jsp");
		
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
