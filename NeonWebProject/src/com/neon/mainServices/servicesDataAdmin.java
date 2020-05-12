package com.neon.mainServices;

import java.sql.SQLException;

import java.util.ArrayList;

import com.neon.model.Admin;
import com.neon.model.Audio;
import com.neon.model.Customer;
import com.neon.model.Document;
import com.neon.model.Video;
import com.neon.model.photos;
import com.neon.util.AdminDB;
import com.neon.util.AudioDAO;
import com.neon.util.CustomerDB;
import com.neon.util.PhotosDAO;
import com.neon.util.VideoDAO;
import com.neon.util.uploadDAO;


//implementing the interface
public class servicesDataAdmin implements InterfaceServicesDataAdmin {
	//overriding the abstract methods of the interface	

	@SuppressWarnings("static-access")
	@Override
//this method is used to get admin details to be used in the admin page and for the picture and login displayed on the top righthand corner	
	public ArrayList<Admin> getAdmin(String adminID) {

		AdminDB ad = new AdminDB();
		ArrayList<Admin> adminDetails = new ArrayList<>();
		try {
			adminDetails = (ArrayList<Admin>)ad.getAdminList(adminID);
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminDetails;
	}

	//this method is used to get customer details from db to be displayed in delete user page
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Customer> getCustomerList() {

		CustomerDB cus = new CustomerDB();
		ArrayList<Customer> customerDetails = new ArrayList<>();
		try {
			customerDetails = (ArrayList<Customer>)cus.getCustomerList();
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerDetails;
	}
	
	//this metho is used to retreive details of photos from DB to be displayed on edit content and delete content pages
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<photos> getphotoList(String userId) {
		PhotosDAO phot = new PhotosDAO();
		ArrayList<photos> photoDetails = new ArrayList<>();
		try {
			photoDetails = (ArrayList<photos>)phot.getPhotoList(userId);
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return photoDetails;
	}

	//this metho is used to retreive details of audio from DB to be displayed on edit content and delete content pages

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Audio> getAudioList(String userId) {
		AudioDAO aud = new AudioDAO();
		ArrayList<Audio> audioDetails = new ArrayList<>();
		try {
			audioDetails = (ArrayList<Audio>)aud.getAudioList(userId);
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return audioDetails;
	}
	
	//this metho is used to retreive details of documents from DB to be displayed on edit content and delete content pages

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Document> getDocumentlist(String userId) {
		uploadDAO docDAO = new uploadDAO();
		ArrayList<Document> docDetails = new ArrayList<>();
		try {
			docDetails = (ArrayList<Document>)docDAO.getDocumentlist(userId);
		}catch(ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docDetails;
	}
	
	//this metho is used to retreive details of videos from DB to be displayed on edit content and delete content pages

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Video> getVideoList(String userID) {

		VideoDAO vid = new VideoDAO();
		ArrayList<Video> videoDetails = null;
		try {
			videoDetails = (ArrayList<Video>) vid.getVideoList(userID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return videoDetails;

	}
	

}
