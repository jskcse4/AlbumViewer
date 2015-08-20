package com.jskhaleel.uploading.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.jskhaleel.uploading.R;
import com.jskhaleel.uploading.albumfragment.AlbumGridFragment;
import com.jskhaleel.uploading.base.BaseCompatActivity;
import com.jskhaleel.uploading.base.HomeBaseFragment;
import com.jskhaleel.uploading.constant.Constants;
import com.jskhaleel.uploading.contactfragment.ContactFragment;
import com.jskhaleel.uploading.login.LoginActivity;
import com.jskhaleel.uploading.utils.AVLog;

import java.util.ArrayList;

public class HomeActivity extends BaseCompatActivity implements DrawerLayout.DrawerListener, MenuListAdapter.OnMenuClickListener, Constants {


    private DrawerLayout mDrawerLayout;
    private ListView mMenuItemsView;
    private MenuListAdapter mMenuListAdapter;
    private ArrayList<String> menuArray;
    private static String mCurrentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    @Override
    protected boolean closeOnBackAction() {
        return false;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT) || mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.closeDrawers();
        } else {
            HomeBaseFragment baseFragment = (HomeBaseFragment) getSupportFragmentManager().findFragmentById(R.id.content_view);
            if (baseFragment.onBackPressed()) {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(Gravity.LEFT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMenuItemsView = (ListView) findViewById(R.id.menu_list);
        menuArray = new ArrayList<>();
        if(getUserPreference().getUserRole().equalsIgnoreCase("0")) {
            menuArray.add(getString(R.string.sample_photos));
            menuArray.add(getString(R.string.sample_videos));
            menuArray.add(getString(R.string.sample_album));
            menuArray.add(getString(R.string.contact));
            menuArray.add(getString(R.string.pincode));
            mCurrentTag = getString(R.string.sample_photos);
            mMenuListAdapter = new MenuListAdapter(menuArray, this, this);
        }else if(getUserPreference().getUserRole().equalsIgnoreCase("1")) {
            menuArray.add(getString(R.string.my_album));
            menuArray.add(getString(R.string.contact));
            menuArray.add(getString(R.string.logout));
            mCurrentTag = getString(R.string.my_album);
            mMenuListAdapter = new MenuListAdapter(menuArray, this, this);
        }

        mMenuItemsView.setAdapter(mMenuListAdapter);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.theme_primary_dark));
        mDrawerLayout.setDrawerListener(this);

        setHeaderLayout();
        addFragment(new AlbumGridFragment());
    }

    private void setHeaderLayout() {
        ViewCompat.setElevation(findViewById(R.id.left_menu_header), 4f);
        TextView userName = (TextView) findViewById(R.id.user_name);
        userName.setText(getUserPreference().getAlbumName());
    }

    public DrawerLayout getDrawer() {
        return mDrawerLayout;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view, fragment).commit();
    }

    @Override
    public void onMenuClick(String tag) {
        AVLog.print(tag);
        mDrawerLayout.closeDrawer(GravityCompat.START);

        if(tag.equalsIgnoreCase(mCurrentTag)) {
            return;
        }

        if(tag.equalsIgnoreCase(getString(R.string.sample_photos))) {
            addFragment(new AlbumGridFragment());
        }else if(tag.equalsIgnoreCase(getString(R.string.sample_videos))) {
            addFragment(new AlbumGridFragment());
        }else if(tag.equalsIgnoreCase(getString(R.string.sample_album))) {
            addFragment(new AlbumGridFragment());
        }else if(tag.equalsIgnoreCase(getString(R.string.contact))) {
            addFragment(new ContactFragment());
        }else if(tag.equalsIgnoreCase(getString(R.string.pincode))) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_ACTIVITY);
        }else if(tag.equalsIgnoreCase(getString(R.string.my_album))) {
            addFragment(new AlbumGridFragment());
        }else if(tag.equalsIgnoreCase(getString(R.string.logout))) {

        }
    }
}
