package com.neon.mainServices;

import java.util.ArrayList;

import com.neon.model.Audio;

public interface AudioServicesInterface {

	//method to get details of audio for a given user id
	public ArrayList<Audio> getAudioList(String userID);

	//method to get details of audio for a given audio id
	public ArrayList<Audio> getAudioDetails(String audID);

}
