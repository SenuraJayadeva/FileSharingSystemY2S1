package com.neon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neon.model.Login;
import com.neon.util.AdminDB;
import com.neon.util.LoginDBAdmin;




@WebServlet("/loginControllerAdmin")
public class loginControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login log = new Login();
		
		log.setEmail(request.getParameter("userName"));
		log.setPassword(request.getParameter("password"));
				
		LoginDBAdmin checkCredentials = new LoginDBAdmin();
		try {
			boolean res = checkCredentials.adminLog(log);
		
			if(res == true ) {
				HttpSession session = request.getSession();
				session.setAttribute("userName",request.getParameter("userName"));
				session.setAttribute("password",request.getParameter("password"));
				
				String FileName = AdminDB.getAdminImagePath(request.getParameter("userName"));
				session.setAttribute("path", FileName);
				
				response.sendRedirect("admin.jsp");
				
			}else {
				response.sendRedirect("adminLogin.jsp");

			}
			
		}catch(ClassNotFoundException | SQLException e) {
			
			PrintWriter writer = response.getWriter();
			writer.print("Error");
			e.printStackTrace();
		}
	}

}
