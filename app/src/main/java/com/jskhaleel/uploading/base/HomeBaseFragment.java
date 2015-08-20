package com.jskhaleel.uploading.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jskhaleel.uploading.R;
import com.jskhaleel.uploading.home.HomeActivity;


public class HomeBaseFragment extends BaseFragment {

    protected Toolbar mToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar(view);
    }

    protected HomeActivity getHomeActivity() {
        return (HomeActivity) getActivity();
    }

    private void setupToolbar(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        getAppCompatActivity().setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    public boolean onBackPressed() {
        return true;
    }
}
