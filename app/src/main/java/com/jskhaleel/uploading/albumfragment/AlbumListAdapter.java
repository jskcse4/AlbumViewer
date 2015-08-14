package com.jskhaleel.uploading.albumfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AlbumListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<AlbumBean> albumList;
    private Context context;

    public AlbumListAdapter(ArrayList<AlbumBean> albumList, Context context) {
        this.albumList  =   albumList;
        this.context    =   context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
