package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.ShareFiles;

public interface ShareFilesServicesInterface {

	//method to get the details of shared files
	public ArrayList<ShareFiles> getSharedFileList(String ReceivedUserID);

}
