package com.neon.model;

public class Document extends File {


	private String docId;

	public Document() {
		super();
	}

	public Document(String docId, String userID, String name, String description, String filename, String path) {
		
		super(userID, name, description, filename, path);
		
		this.docId = docId;
		
	}
	
	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
	
	


}
