package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neon.model.ShareFiles;
import com.neon.util.ShareFilesDAO;

public class ShareFilesServices implements ShareFilesServicesInterface{
	
	
	//method to get the details of shared files
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<ShareFiles> getSharedFileList(String ReceivedUserID) {
		
		ShareFilesDAO  sfDAO = new ShareFilesDAO();
		
		
		ArrayList<ShareFiles> sharedfileList = null;
		try {
			sharedfileList = (ArrayList<ShareFiles>) sfDAO.getSharedFileList(ReceivedUserID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return sharedfileList;
		
		
	
	}
	

}
