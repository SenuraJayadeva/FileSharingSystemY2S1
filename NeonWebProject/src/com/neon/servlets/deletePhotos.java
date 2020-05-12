package com.neon.servlets;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.photos;
import com.neon.util.PhotosDAO;


@WebServlet("/deletePhotos")
public class deletePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//creating an object of type photos
		photos photo = new photos();
//initializing the parameters using settes	
		photo.setPhotoID(request.getParameter("photoID"));
		photo.setUserID(request.getParameter("userID"));
		photo.setFilename(request.getParameter("fileName"));
		
//getting an instance of type photo database
		PhotosDAO photDAO = new PhotosDAO();
		
		
		try {
//calling the delete photo method in photoDAO class			
			photDAO.deletePhoto(photo);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirecting
		response.sendRedirect("user");	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
