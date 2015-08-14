package com.jskhaleel.uploading.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.jskhaleel.uploading.R;
import com.jskhaleel.uploading.albumfragment.AlbumGridFragment;
import com.jskhaleel.uploading.base.BaseCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends BaseCompatActivity implements DrawerLayout.DrawerListener, MenuListAdapter.OnMenuClickListener {


    private DrawerLayout mDrawerLayout;
    private ListView mMenuItemsView;
    private MenuListAdapter mMenuListAdapter;
    private ArrayList<String> menuArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }


    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMenuItemsView = (ListView) findViewById(R.id.menu_list);
        menuArray = new ArrayList<>();
        if(getUserPreference().getUserRole().equalsIgnoreCase("0")) {
            menuArray.add("Sample Photos");
            menuArray.add("Sample Videos");
            menuArray.add("Sample Album");
            menuArray.add("Contact");
            menuArray.add("I Have Pincode");
            mMenuListAdapter = new MenuListAdapter(menuArray, this, this);
        }else if(getUserPreference().getUserRole().equalsIgnoreCase("1")) {
            menuArray.add("Album");
            menuArray.add("Contact");
            menuArray.add("Logout");
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

    }
}
