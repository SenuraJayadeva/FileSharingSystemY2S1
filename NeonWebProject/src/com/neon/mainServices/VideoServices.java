package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;
import com.neon.model.Video;
import com.neon.util.VideoDAO;

public class VideoServices implements VideoServicesInterface{
	
	//override the method to get details of Video for a given user id
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
	
	//override the method to get details of audio for a given videoID 
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Video> getVideoDetails(String videoID) {

		VideoDAO vid = new VideoDAO();
		ArrayList<Video> videoDetails = null;
		try {
			videoDetails = (ArrayList<Video>) vid.getVideoListToShare(videoID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return videoDetails;

	}

}
