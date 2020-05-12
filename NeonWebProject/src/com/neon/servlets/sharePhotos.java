package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.ShareFiles;
import com.neon.util.ShareFilesDAO;
//servlet mapping
@WebServlet("/sharePhotos")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class sharePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//creating an object from share files class
		ShareFiles sf = new ShareFiles();
		
	//initializing the attributes of the object	
		sf.setReceivedUserEmail(request.getParameter("sharePhotos_receivedUser"));
		sf.setFileID(request.getParameter("sharePhotos_photoID"));
		sf.setFileType("Photo");
		sf.setSenderUserID(request.getParameter("sharePhotos_sendUser"));
		sf.setSenderImagePath(request.getParameter("sharePhotos_sendUserImagePath"));
		sf.setName(request.getParameter("sharePhotos_name"));
		sf.setDescription(request.getParameter("sharePhotos_description"));
		sf.setFilename(request.getParameter("sharePhotos_filename"));
		sf.setPath(request.getParameter("sharePhotos_path"));

		//creating an object from sharefilesDAO class

		ShareFilesDAO sfDAO = new ShareFilesDAO();

	
		
		try {
			
		//passing the share files object to the insert method of the database class	
			sfDAO.insertShareFile(sf);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		//redirecting
		response.sendRedirect("user");
		
	}
}


