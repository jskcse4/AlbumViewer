package com.jskhaleel.uploading.webservice;

import android.content.Context;

import com.jskhaleel.uploading.preferences.UserPreference;
import com.jskhaleel.uploading.utils.AVLog;
import com.jskhaleel.uploading.utils.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

public class AVHttpClient {

    private int SOCKET_TIMEOUT = 60 * 1000;
    private AsyncHttpClient httpClient;
    private Context context;
    private UserPreference mPreference;

    public AVHttpClient(Context context) {
        httpClient = new AsyncHttpClient();
        httpClient.setTimeout(SOCKET_TIMEOUT);
        this.context = context;
        mPreference = new UserPreference(context);
        addHeader();
    }

    private void addHeader() {
        if (!TextUtils.isNullOrEmpty(mPreference.getAccessToken())) {
            httpClient.addHeader("Authorization", "Bearer " + mPreference.getAccessToken());
        }
    }

    public void performRequest(String url, HttpMethod method, RequestParams params, final AVRequestHandler handler) {
        performRawRequest(url, method, params, new AVResponseHandler(url, method) {
            @Override
            public void onSuccess(String content) {
                if (handler != null) {
                    handler.onSuccess(content);
                }
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, String message) {
                if (handler != null) {
                    handler.onFailure(statusCode, throwable, message);
                }
            }
        });
    }

    private void performRawRequest(String url, HttpMethod method, RequestParams params, AVResponseHandler handler) {
        if (params == null) {
            params = new RequestParams();
        }

        if (method == HttpMethod.GET) {
            httpClient.get(context, url, params, handler);
        }else {
            throw new NoSuchMethodError("No such HTTP method available");
        }
    }

    public void login(RequestParams params, final RequestListener listener) {

        if (params != null) {
            params.put("grant_type", "password");
            params.put("client_id", getClientId());
            params.put("client_secret", getClientSecret());
            params.put("scope", "user");
        }

        performRequest(Webservice.LOGIN, HttpMethod.POST, params, new AVRequestHandler() {
            @Override
            public void onSuccess(String content) {
                AVLog.print("login: " + content);
                try {
                    JSONObject obj = new JSONObject(content);
                    obj = obj.optJSONObject("loginInfo");
                    String accessToken = obj.optString("access_token");

                    mPreference.setAccessToken(accessToken);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                addHeader();
                listener.onComplete();
            }

            @Override
            public void onFailure(int statusCode, Throwable error, String message) {
                AVLog.print("login: " + statusCode + message);
                listener.onError(message);
            }
        });
    }

    private String getClientId() {
        return "2_5qffgdytaaw4o0s40swk4uo0ckco80sws0ccso0w_w080g4c40";
    }

    private String getClientSecret() {
        return "2l2ns4dmedgkg0cs40ksc4c8gwg4kkkkmm8cgkgcksgg04co8s";
    }

    public void logout(Context context) {
        httpClient.removeHeader("Authorization");
        mPreference.logout();
    }

    public static enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    public static interface RequestListener {
        void onComplete();

        void onError(String message);
    }
}
