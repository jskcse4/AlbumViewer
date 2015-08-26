package com.jskhaleel.albumviewer.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {

    private static final String PREFS_NAME = "user_preference";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String USER_ID = "user_id";
    private static final String USER_LOGGED_IN = "user_logged_in";
    private static final String ALBUM_NAME = "album_name";

    private static final String USER_NAME = "user_name";

    private SharedPreferences mPreference;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public UserPreference(Context context) {
        mContext = context;
        mPreference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mEditor = mPreference.edit();
    }

    public String getAccessToken() {
        return mPreference.getString(ACCESS_TOKEN, "");
    }

    public void setAccessToken(String accessToken) {
        mEditor.putString(ACCESS_TOKEN, accessToken);
        mEditor.commit();
    }

    public String getUserId() {
        return mPreference.getString(USER_ID, "");
    }

    public void setUserId(String userId) {
        mEditor.putString(USER_ID, userId);
        mEditor.commit();
    }

    public String getAlbumName() {
        return mPreference.getString(ALBUM_NAME, "");
    }

    public void setAlbumName(String albumName) {
        mEditor.putString(ALBUM_NAME, albumName);
        mEditor.commit();
    }

    public boolean getUserLogged() {
        return mPreference.getBoolean(USER_LOGGED_IN, false);
    }

    public void setUserLogged(boolean isLoggedIn) {
        mEditor.putBoolean(USER_LOGGED_IN, isLoggedIn);
        mEditor.commit();
    }

    public String getUserName() {
        return mPreference.getString(USER_NAME, "");
    }

    public void setUserName(String userName) {
        mEditor.putString(USER_NAME, userName);
        mEditor.commit();
    }

    public void logout() {
        mEditor.clear();
        mEditor.commit();
    }
}
