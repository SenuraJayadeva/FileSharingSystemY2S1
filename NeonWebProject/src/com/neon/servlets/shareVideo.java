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

@WebServlet("/shareVideo")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)


public class shareVideo extends HttpServlet {

	private static final long serialVersionUID = 1L;
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShareFiles sf = new ShareFiles();
		
		
		sf.setReceivedUserEmail(request.getParameter("shareVideo_receivedUser"));
		sf.setFileID(request.getParameter("shareVideo_audioID"));
		sf.setFileType("Video");
		sf.setSenderUserID(request.getParameter("shareVideo_sendUser"));
		sf.setSenderImagePath(request.getParameter("shareVideo_sendUserImagePath"));
		sf.setName(request.getParameter("shareVideo_name"));
		sf.setDescription(request.getParameter("shareVideo_description"));
		sf.setFilename(request.getParameter("shareVideo_filename"));
		sf.setPath(request.getParameter("shareVideo_path"));
		
		
		ShareFilesDAO sfDAO = new ShareFilesDAO();
	
		try {
			
			
			sfDAO.insertShareFile(sf);
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		response.sendRedirect("user");
		
	}
}
