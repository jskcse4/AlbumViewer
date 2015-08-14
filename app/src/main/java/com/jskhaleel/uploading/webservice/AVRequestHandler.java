package com.jskhaleel.uploading.webservice;

public interface AVRequestHandler {
    void onSuccess(String content);
    void onFailure(int statusCode, Throwable error, String message);
}
