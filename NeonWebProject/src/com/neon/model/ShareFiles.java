package com.neon.model;

public class ShareFiles {
	
	

	private String shareID;
	
	private String ReceivedUserEmail;
	
	private String FileID;
	
	private String FileType;
	
	private String senderUserID;
	
	private String senderImagePath;
	
	private String name;
	
	private String description;
	
	private String filename;
	
	private String path;
	
	
	
	public ShareFiles() {
		super();
	}

	public ShareFiles(String shareID, String receivedUserEmail, String fileID, String fileType, String senderUserID,
			String senderImagePath, String name, String description, String filename, String path) {
		super();
		this.shareID = shareID;
		ReceivedUserEmail = receivedUserEmail;
		FileID = fileID;
		FileType = fileType;
		this.senderUserID = senderUserID;
		this.senderImagePath = senderImagePath;
		this.name = name;
		this.description = description;
		this.filename = filename;
		this.path = path;
	}

	public String getShareID() {
		return shareID;
	}

	public void setShareID(String shareID) {
		this.shareID = shareID;
	}

	public String getReceivedUserEmail() {
		return ReceivedUserEmail;
	}

	public void setReceivedUserEmail(String receivedUserEmail) {
		ReceivedUserEmail = receivedUserEmail;
	}

	public String getFileID() {
		return FileID;
	}

	public void setFileID(String fileID) {
		FileID = fileID;
	}

	public String getFileType() {
		return FileType;
	}

	public void setFileType(String fileType) {
		FileType = fileType;
	}

	public String getSenderUserID() {
		return senderUserID;
	}

	public void setSenderUserID(String senderUserID) {
		this.senderUserID = senderUserID;
	}
	
	public String getSenderImagePath() {
		return senderImagePath;
	}

	public void setSenderImagePath(String senderImagePath) {
		this.senderImagePath = senderImagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	

}
