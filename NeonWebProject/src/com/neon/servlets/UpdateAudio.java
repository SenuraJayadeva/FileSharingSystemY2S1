package com.neon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Audio;
import com.neon.model.Login;
import com.neon.util.AudioDAO;
import com.neon.util.LoginDBAdmin;


@WebServlet("/UpdateAudio")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class UpdateAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form
		response.setContentType("text/html;charset=UTF-8");
		
		Audio audio = new Audio();
		
		//get parameters and assigned it to the set methods of Audio class
		audio.setAudioID(request.getParameter("audID"));
		audio.setName(request.getParameter("title"));
		audio.setDescription(request.getParameter("description"));
		
		
		PrintWriter writer = response.getWriter();
		
		writer.print(request.getParameter("audID"));
		writer.print(request.getParameter("title"));
		writer.print(request.getParameter("description"));
		
		AudioDAO audDAO = new AudioDAO();
		try {
			audDAO.UpdateAudioDetails(audio);
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
