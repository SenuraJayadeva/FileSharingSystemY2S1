package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neon.model.Document;
import com.neon.util.uploadDAO;

public class DocumentServices implements DocumentServicesInterface{
	
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Document> getDocumentDetails(String docID) {

		uploadDAO doc = new uploadDAO();
		ArrayList<Document> docDetails = null;
		try {
			docDetails = (ArrayList<Document>) doc.getDocumentDetails(docID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docDetails;

	}
	

}
