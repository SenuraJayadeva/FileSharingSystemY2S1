package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Document;
import com.neon.model.Login;
import com.neon.util.LoginDBAdmin;
import com.neon.util.uploadDAO;


@WebServlet("/UpdateDocument")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class UpdateDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form
		response.setContentType("text/html;charset=UTF-8");
		
		//set values to the parameters
		Document document = new Document();
		document.setDocId(request.getParameter("docID"));
		document.setName(request.getParameter("title"));
		document.setDescription(request.getParameter("description"));
		
		//create an object of uploadDAO class to access the method
		uploadDAO docDAO = new uploadDAO();
		try {
			docDAO.UpdateDocumentDetails(document);
		} catch (ClassNotFoundException | SQLException e) {
		
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
