package com.jskhaleel.uploading.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jskhaleel.uploading.AlbumViewerApp;
import com.jskhaleel.uploading.preferences.UserPreference;

import java.lang.reflect.Method;

abstract public class BaseCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (closeOnBackAction()) {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public AlbumViewerApp getApp() {
        return (AlbumViewerApp) getApplication();
    }

    public UserPreference getUserPreference(){
        return getApp().getUserPreference();
    }

    protected boolean isPageVisible() {
        return BaseCompatActivity.this != null;
    }

    protected boolean closeOnBackAction() {
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("android.support.v7.internal.view.menu.MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                    Log.e("BaseActivity", "onMenuOpened");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

}
