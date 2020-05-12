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

import com.neon.model.Login;
import com.neon.model.photos;
import com.neon.util.LoginDBAdmin;
import com.neon.util.PhotosDAO;

//servlet mapping
@WebServlet("/UpdatePhoto")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class UpdatePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
//creating an object from photos class

		photos photo = new photos();

//initializing the attributes of the object	using the values from the request variable

		photo.setPhotoID(request.getParameter("photoID"));
		photo.setName(request.getParameter("title"));
		photo.setDescription(request.getParameter("description"));
		
		
		PrintWriter writer = response.getWriter();
		
		writer.print(request.getParameter("photoID"));
		writer.print(request.getParameter("title"));
		writer.print(request.getParameter("description"));

//creating an object from photoDAO class

		PhotosDAO photDAO = new PhotosDAO();
		try {
//passing the photo object to the update method of the database class	

			photDAO.UpdatePhotoDetails(photo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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