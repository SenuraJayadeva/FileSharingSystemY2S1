package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.Document;

public interface DocumentServicesInterface {

	public ArrayList<Document> getDocumentDetails(String docID);

}
