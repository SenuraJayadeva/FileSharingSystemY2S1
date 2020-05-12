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


@WebServlet("/shareAudio")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)


public class shareAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShareFiles sf = new ShareFiles();
		
		//get parameters and assigned it to the set methods of ShareFiles class
		sf.setReceivedUserEmail(request.getParameter("shareAudio_receivedUser"));
		sf.setFileID(request.getParameter("shareAudio_audioID"));
		sf.setFileType("Audio");
		sf.setSenderUserID(request.getParameter("shareAudio_sendUser"));
		sf.setSenderImagePath(request.getParameter("shareAudio_sendUserImagePath"));
		sf.setName(request.getParameter("shareAudio_name"));
		sf.setDescription(request.getParameter("shareAudio_description"));
		sf.setFilename(request.getParameter("shareAudio_filename"));
		sf.setPath(request.getParameter("shareAudio_path"));
		

		
		ShareFilesDAO sfDAO = new ShareFilesDAO();

		
		try {
			
			//call the insertShareFile method of ShareFilesDAO class and send sf object of ShareFiles class as a parameter
			sfDAO.insertShareFile(sf);
	
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		response.sendRedirect("user");
		
	}
	
	


}
