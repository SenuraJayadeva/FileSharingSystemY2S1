package com.neon.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neon.model.Audio;
import com.neon.model.Customer;
import com.neon.model.Document;
import com.neon.model.Login;
import com.neon.model.ShareFiles;
import com.neon.model.Video;
import com.neon.model.photos;
import com.neon.util.AudioDAO;
import com.neon.util.CustomerDB;
import com.neon.util.LoginDBAdmin;
import com.neon.util.PhotosDAO;
import com.neon.util.ShareFilesDAO;
import com.neon.util.VideoDAO;
import com.neon.util.uploadDAO;


@WebServlet("/user")
public class userHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		
		//get session attribute
		String userName = (String) session.getAttribute("userName");
		
		
		try {
			
			//call getCustomerList method of CustomerDB class
			List<Customer> customerDeatils  = CustomerDB.getCustomerList(userName);
			request.setAttribute("customerDetails", customerDeatils);
			
			//call getAudioList method of AudioDAO class
			List<Audio> audioDetails =  AudioDAO.getAudioList(userName);
			request.setAttribute("audioDetails", audioDetails);
			
			//call getSharedFileList method of ShareFilesDAO class
			List<ShareFiles> shareFileDetails =  ShareFilesDAO.getSharedFileList(userName);
			request.setAttribute("shareFileDetails", shareFileDetails);
			
			//call getPhoto method of PhotosDAO class
			List<photos> photoDetails =  PhotosDAO.getPhotoList(userName);
			request.setAttribute("photoDetails", photoDetails);
			
			//call getVideoList method of VideoDAO class
			List<Video> videoDetails =  VideoDAO.getVideoList(userName);
			request.setAttribute("videoDetails", videoDetails);
			
			//call getDocumentlist method of uploadDAO class
			List<Document> documentDetails = uploadDAO.getDocumentlist(userName);
			request.setAttribute("documentDetails",documentDetails);
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create a object of Login class
		Login log = new Login();
		
		
		log.setEmail((String) session.getAttribute("userName"));
		log.setPassword((String) session.getAttribute("password"));
		
		
		LoginDBAdmin checkCredentials = new LoginDBAdmin();
		try {
			
			boolean res = checkCredentials.adminLog(log);
			if(res == true ) {
				
				//if the condition is true page will redirected to admin.jsp
				response.sendRedirect("admin.jsp");
				
			}else {
				
				////if the condition is false page will redirected to user.jsp
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
				
				requestDispatcher.forward(request, response);
				

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		
	}



}
