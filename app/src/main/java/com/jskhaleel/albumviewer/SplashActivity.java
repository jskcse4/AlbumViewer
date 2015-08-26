package com.jskhaleel.albumviewer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jskhaleel.albumviewer.base.BaseCompatActivity;
import com.jskhaleel.albumviewer.home.HomeActivity;

import java.lang.ref.WeakReference;

public class SplashActivity extends BaseCompatActivity {

    private static final long SLEEP_DURATION = 1000l;
    private AVHandler avHandler;
    private boolean isDestroyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        avHandler = new AVHandler(this);
        avHandler.sendEmptyMessageDelayed(1, SLEEP_DURATION);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroyed = true;
    }

    private void launchNextScreen() {
        finish();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    static class AVHandler extends Handler{
        WeakReference<SplashActivity> splash;

        public AVHandler(SplashActivity splashActivity) {
            splash = new WeakReference<SplashActivity>(splashActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = splash.get();
            if (activity != null && msg.what == 1 && !activity.isDestroyed) {
                activity.launchNextScreen();
            }
        }
    }
}
