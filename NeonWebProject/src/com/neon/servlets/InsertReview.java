package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.Review;
import com.neon.util.ReviewDB;




@WebServlet("/InsertReview")
public class InsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form

		Review rev = new Review();
		rev.setName(request.getParameter("name"));
		rev.setCountry(request.getParameter("Country"));
		rev.setEmail(request.getParameter("email"));
		rev.setMessage(request.getParameter("message"));
		rev.setRating(request.getParameter("rating"));
		
		
		ReviewDB revDB = new ReviewDB();
		try {
			revDB.insertReview(rev);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("index.jsp");
				
	}
	
	

}
