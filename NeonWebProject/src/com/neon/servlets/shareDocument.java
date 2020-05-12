package com.neon.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.ShareFiles;
import com.neon.util.ShareFilesDAO;




@WebServlet("/shareDocument")

//giving a maximum file size
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
maxFileSize = 1024 * 1024 * 10, //10MB
maxRequestSize = 1024 * 1024 * 50)

public class shareDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ShareFiles share = new ShareFiles();
		
		//set values to the parameters
		share.setReceivedUserEmail(request.getParameter("shareDocument_receivedUser"));
		share.setFileID(request.getParameter("shareDocument_docID"));
		share.setFileType("Document");
		share.setSenderUserID(request.getParameter("shareDocument_sendUser"));
		share.setSenderImagePath(request.getParameter("shareDocument_sendUserImagePath"));
		share.setName(request.getParameter("shareDocument_name"));
		share.setDescription(request.getParameter("shareDocument_description"));
		share.setFilename(request.getParameter("shareDocument_filename"));
		share.setPath(request.getParameter("shareDocument_path"));
		
		ShareFilesDAO shareDAO = new ShareFilesDAO();
		
		try {
			
			shareDAO.insertShareFile(share);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("user");
	}

}
