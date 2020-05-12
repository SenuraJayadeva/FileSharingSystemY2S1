package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.Admin;
import com.neon.model.Audio;
import com.neon.model.Customer;
import com.neon.model.Document;
import com.neon.model.Video;
import com.neon.model.photos;



public interface InterfaceServicesDataAdmin {

	//abstract methods
	public ArrayList<Admin> getAdmin(String adminID);
	public ArrayList<Customer> getCustomerList();
	public ArrayList<photos> getphotoList(String userId);
	public ArrayList<Audio> getAudioList(String userId);
	public ArrayList<Document> getDocumentlist(String userId);
	public ArrayList<Video> getVideoList(String userID);
	
}
