package com.neon.mainServices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neon.model.Audio;
import com.neon.util.AudioDAO;


//This class implements the AudioServicesInterface Interface
public class AudioServices implements AudioServicesInterface{
	
	
	//override the method to get details of audio for a given user id
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<Audio> getAudioList(String userID) {

		AudioDAO aud = new AudioDAO();
		ArrayList<Audio> audioDetails = null;
		try {
			audioDetails = (ArrayList<Audio>) aud.getAudioList(userID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return audioDetails;

	}
	
	//override the method to get details of audio for a given audio id
	@Override
	public ArrayList<Audio> getAudioDetails(String audID) {

		AudioDAO aud = new AudioDAO();
		ArrayList<Audio> audioDetails = null;
		try {
			audioDetails = (ArrayList<Audio>) aud.getAudioDetails(audID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return audioDetails;

	}
	

}
