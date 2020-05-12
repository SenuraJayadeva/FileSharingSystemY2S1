package com.neon.servlets;

import java.io.File;
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
import javax.servlet.http.Part;

import com.neon.model.Audio;
import com.neon.util.AudioDAO;


@WebServlet("/InsertAudio")

//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2000,//2MB
					maxFileSize = 1024 * 1024 * 10000, //10MB
					maxRequestSize = 1024 * 1024 * 50000)


	
public class InsertAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		//include following 2 lines.otherwise this will not work correctly when getting values from a form
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
	
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		
		//path to store the file
		String savePath = "C:\\Users\\Senura\\eclipse-workspace\\NeonWebProject\\WebContent\\Storage\\" + File.separator + fileName;
		part.write(savePath + File.separator); 
		
		
		Audio audio = new Audio();
		
		//get parameters and assigned it to the set methods of Audio class
		audio.setUserID(userName);
		audio.setName(request.getParameter("name"));
		audio.setDescription(request.getParameter("description"));
		audio.setFilename(fileName);
		audio.setPath(savePath);
		
			
		AudioDAO audDao = new AudioDAO();
	
		
		
		try {
			
			//call the insertAudio method of AudioDAO class and send audio object of Audio class as a parameter		
			audDao.insertAudio(audio);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			out.print("Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("user");
		
				
				
	}
	
	//this is related to file path
	private String extractFileName(Part part) {

		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if(s.trim().startsWith("filename")) {
				
				return s.substring(s.indexOf("=") + 2,s.length() - 1);
				
			}
		}
		return "";
	}

}
