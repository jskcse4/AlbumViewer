package com.jskhaleel.uploading.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.Menu;

import com.jskhaleel.uploading.AlbumViewerApp;
import com.jskhaleel.uploading.preferences.UserPreference;

import java.lang.reflect.Method;

public class BaseFragment extends Fragment {

    public AlbumViewerApp getApp() {
        return (AlbumViewerApp) getActivity().getApplication();
    }

    public UserPreference getUserPreference(){
        return getApp().getUserPreference();
    }

    public boolean isPageVisible(){
        return getActivity() != null;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    public BaseCompatActivity getAppCompatActivity(){
        return (BaseCompatActivity) getActivity();
    }

    public ActionBar getSupportActionBar(){
        return getAppCompatActivity().getSupportActionBar();
    }

}
