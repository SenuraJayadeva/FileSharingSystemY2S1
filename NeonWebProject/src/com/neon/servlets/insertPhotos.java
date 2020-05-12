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
import com.neon.model.photos;
import com.neon.util.PhotosDAO;



//servlet mapping
@WebServlet("/insertPhotos")
//Here define the size of a file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)


public class insertPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
	
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\ASUS\\eclipse-workspace\\NeonWebProject\\WebContent\\Storage\\" + File.separator + fileName;
		part.write(savePath + File.separator); 
		
//creating an instance of type photo		
		photos photo = new photos();
// initializing tha attributes of the object		
		photo.setUserID(userName);
		photo.setName(request.getParameter("name"));
		photo.setDescription(request.getParameter("description"));
		photo.setFilename(fileName);
		photo.setPath(savePath);
			
//creating an instance of type photoDAO class				
		PhotosDAO photDAO = new PhotosDAO();
		
		
		try {
//calling the insert photo method passing the photo object as a parameter					
			photDAO.insertPhotos(photo);
			
		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter out = response.getWriter();
			out.print("Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//redirecting		
		response.sendRedirect("user");
		
	}
	
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
