package com.jskhaleel.albumviewer.webservice;

public interface AVRequestHandler {
    void onSuccess(String content);
    void onFailure(int statusCode, Throwable error, String message);
}
