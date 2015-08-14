package com.jskhaleel.uploading.utils;

import android.util.Log;

public class AVLog {

    public static void print(String str) {
        if (str.length() > 4000) {
            Log.e("AVLog", str.substring(0, 4000));
            print(str.substring(4000));
        } else {
            Log.e("AVLog", str);
        }
    }
}
