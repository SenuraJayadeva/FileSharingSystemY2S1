package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Login;
import com.neon.model.Video;
import com.neon.util.LoginDBAdmin;
import com.neon.util.VideoDAO;


@WebServlet("/UpdateVideo")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class UpdateVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form
		response.setContentType("text/html;charset=UTF-8");
		
		Video video = new Video();
		video.setVideoID(request.getParameter("videoID"));
		video.setName(request.getParameter("title"));
		video.setDescription(request.getParameter("description"));
	
		VideoDAO vidDAO = new VideoDAO();
		try {
			vidDAO.UpdateVideoDetails(video);
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
