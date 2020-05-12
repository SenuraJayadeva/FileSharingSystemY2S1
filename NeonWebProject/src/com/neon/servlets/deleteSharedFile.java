package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.ShareFiles;
import com.neon.util.ShareFilesDAO;


@WebServlet("/deleteSharedFile")
public class deleteSharedFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShareFiles shareFiles = new ShareFiles();
		
		shareFiles.setShareID(request.getParameter("shareID"));
		
		ShareFilesDAO sfDAO = new ShareFilesDAO();
		
		try {
			sfDAO.deleteSharedFiles(shareFiles);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("sharedStorage.jsp");
		
	}
	
	
		



}
