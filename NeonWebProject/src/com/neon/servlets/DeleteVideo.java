package com.neon.servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neon.model.Video;
import com.neon.util.VideoDAO;

@WebServlet("/deleteVideo")
public class DeleteVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		Video video = new Video();
		
		video.setVideoID(request.getParameter("videoID"));
		video.setUserID(request.getParameter("userID"));
		video.setFilename(request.getParameter("fileName"));
		

		
		
		VideoDAO vidDAO = new VideoDAO();

		
		
		try {
			
			vidDAO.deleteVideo(video);
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("user");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
