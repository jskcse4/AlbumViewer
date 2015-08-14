package com.jskhaleel.uploading;

import android.app.Application;

import com.jskhaleel.uploading.preferences.UserPreference;
import com.jskhaleel.uploading.webservice.AVHttpClient;

public class AlbumViewerApp extends Application {
	private AVHttpClient httpClient;
	private UserPreference mUserPreference;

	public static boolean GTE_HC_11 = false;
	public static boolean PRE_HC_11 = false;

	@Override
	public void onCreate() {
		super.onCreate();
		httpClient = new AVHttpClient(this);
		mUserPreference = new UserPreference(this);

	}

	public AVHttpClient getHttpClient() {
		return httpClient;
	}

	public UserPreference getUserPreference() {
		return mUserPreference;
	}
}
