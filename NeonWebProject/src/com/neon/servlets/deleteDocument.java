package com.neon.servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neon.model.Document;
import com.neon.util.uploadDAO;



@WebServlet("/deleteDocument")
public class deleteDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Document document = new Document();
		
		document.setDocId(request.getParameter("docId"));
		
		uploadDAO uploadDAO = new uploadDAO();
		
		try {
			uploadDAO.deleteDocument(document);
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		//after deleting the document it should redirect to userReviewHandler
		response.sendRedirect("user");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
