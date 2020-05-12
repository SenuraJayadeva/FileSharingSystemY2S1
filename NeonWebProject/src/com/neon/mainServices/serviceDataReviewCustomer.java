package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;
import com.neon.model.Review;
import com.neon.util.ReviewDB;



public class serviceDataReviewCustomer implements InterfaceServicesReviewCustomer {

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Review> getReviewList() {
		ReviewDB rev = new ReviewDB();
		ArrayList<Review> revDetails = new ArrayList<>();
		try {
			revDetails = (ArrayList<Review>)rev.getReview();
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return revDetails;
	}

}
