package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.Video;

public interface VideoServicesInterface {

	public ArrayList<Video> getVideoList(String userID);

	public ArrayList<Video> getVideoDetails(String videoID);

}
