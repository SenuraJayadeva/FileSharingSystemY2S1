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
import com.neon.model.Customer;
import com.neon.model.Review;
import com.neon.util.CustomerDB;
import com.neon.util.ReviewDB;



@WebServlet("/UserReviewHandler")
public class UserReviewHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserReviewHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		
		try {
			
			
			List<Customer> customerDeatils  = CustomerDB.getCustomerList(userName);
			request.setAttribute("customerDetails", customerDeatils);
			
			List<Review> reviewdtls =  ReviewDB.getReview();
			request.setAttribute("reviewdtls", reviewdtls);
			
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		//redirect to a different page(view)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("aboutUs.jsp");	
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
