package com.jskhaleel.uploading.albumfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jskhaleel.uploading.R;
import com.jskhaleel.uploading.base.HomeBaseFragment;

import java.util.ArrayList;

public class AlbumGridFragment extends HomeBaseFragment {

    private RecyclerView mRecyclerView;

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
        mRecyclerView =   (RecyclerView) rootView.findViewById(R.id.grid_recycler_view);
    }

    private void setupDefaults() {
        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(glm);

        loadImages();
    }

    private void setupEvents() {

    }

    private void loadImages() {
        ArrayList<AlbumBean> albumList = new ArrayList<>();

        AlbumListAdapter adapter = new AlbumListAdapter(albumList, getActivity());
    }
}
