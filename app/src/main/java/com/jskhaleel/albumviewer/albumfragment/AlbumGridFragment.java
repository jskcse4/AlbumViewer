package com.jskhaleel.albumviewer.albumfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jskhaleel.albumviewer.R;
import com.jskhaleel.albumviewer.base.HomeBaseFragment;

import java.util.ArrayList;

public class AlbumGridFragment extends HomeBaseFragment {

    private RecyclerView mRecyclerView;
    private ArrayList<AlbumBean> albumList;
    private View mEmptyView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.album_grid_fragment, container, false);

        init(rootView);
        setupDefaults();
        setupEvents();
        return rootView;
    }

    private void init(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.grid_recycler_view);
        mEmptyView = rootView.findViewById(R.id.empty);

    }

    private void setupDefaults() {
        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
/*        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 2);
            }
        });*/
        mRecyclerView.setLayoutManager(glm);

        loadImages();
    }

    private void setupEvents() {

    }

    private void loadImages() {
        albumList = getAlbumList();

        AlbumGridAdapter gridAdapter = new AlbumGridAdapter(getActivity(), albumList);
        mRecyclerView.setAdapter(gridAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        if(albumList.size() > 0) {
            mEmptyView.setVisibility(View.GONE);
        }else {
            mEmptyView.setVisibility(View.VISIBLE);
        }
    }


    public ArrayList<AlbumBean> getAlbumList() {
        ArrayList<AlbumBean> tempList = new ArrayList<>();
        tempList.add(new AlbumBean("1", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("2", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("3", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("4", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("5", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("6", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("7", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("8", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("9", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("10", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("11", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("12", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("13", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("14", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("15", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("16", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("17", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("18", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("19", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("20", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));
        tempList.add(new AlbumBean("21", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("22", "http://postimg.org/image/xbuzgkjy3/", "http://s17.postimg.org/xbuzgkjy3/nature_wallpaper_latest_190.jpg"));
        tempList.add(new AlbumBean("23", "http://postimg.org/image/4jjmjcmwr/", "http://s17.postimg.org/4jjmjcmwr/Assassins_Creed_2_Wallpaper_HD.jpg"));
        tempList.add(new AlbumBean("24", "http://postimg.org/image/7ewpq7qwr/", "http://s17.postimg.org/7ewpq7qwr/amazing_nature_wallpapers_with_green_leaves_and.jpg"));

        return tempList;
    }
}
