package com.jskhaleel.uploading.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {

    private static final String PREFS_NAME = "user_preference";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String USER_ID = "user_id";
    private static final String USER_ROLE = "user_role";
    private static final String ALBUM_NAME = "album_name";

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

    public String getUserRole() {
        return mPreference.getString(USER_ROLE, "0");
    }

    public void setUserRole(String role) {
        mEditor.putString(USER_ROLE, role);
        mEditor.commit();
    }

    public void logout() {
        mEditor.clear();
        mEditor.commit();
    }
}
