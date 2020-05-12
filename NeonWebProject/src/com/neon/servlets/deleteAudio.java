package com.neon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Audio;
import com.neon.model.Login;
import com.neon.util.AudioDAO;
import com.neon.util.LoginDBAdmin;


@WebServlet("/deleteAudio")
public class deleteAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		Audio audio = new Audio();
		
		//get parameters and assigned it to the set methods of Audio class
		audio.setAudioID(request.getParameter("audioID"));
		audio.setUserID(request.getParameter("userID"));
		audio.setFilename(request.getParameter("fileName"));
		

		AudioDAO audDAO = new AudioDAO();
	
	
		try {
			
			//call the deleteAudio method of AudioDAO class and send audio object of Audio class as a parameter
			audDAO.deleteAudio(audio);
		
			
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
				
				
				response.sendRedirect("adminDeleteContent.jsp");
				
			}else {
				
				response.sendRedirect("user");

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	

}
