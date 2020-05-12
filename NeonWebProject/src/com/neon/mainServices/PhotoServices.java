package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neon.model.photos;
import com.neon.util.PhotosDAO;

public class PhotoServices implements PhotoServicesInterface{
	
	
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<photos> getPhotoListToShare(String picID) {

		PhotosDAO pic = new PhotosDAO();
		ArrayList<photos> photoDetails = null;
		try {
			photoDetails = (ArrayList<photos>) pic.getPhotoListToShare(picID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return photoDetails;

	}

}
