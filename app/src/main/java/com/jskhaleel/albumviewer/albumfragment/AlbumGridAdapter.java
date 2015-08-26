package com.jskhaleel.albumviewer.albumfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jskhaleel.albumviewer.R;
import com.jskhaleel.albumviewer.utils.AVLog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumGridAdapter extends RecyclerView.Adapter<AlbumGridAdapter.GridItemViewHolder> {

    private final LayoutInflater mInflator;
    private Context mContext;
    private ArrayList<AlbumBean> albumList;
    private int lastPosition = -1;

    public AlbumGridAdapter(Context context, ArrayList<AlbumBean> albumList) {
        this.mContext    =   context;
        this.albumList =   albumList;
        mInflator = LayoutInflater.from(context);
    }


    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_grid_item, parent, false);
        return new GridItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GridItemViewHolder holder, final int position) {
        final AlbumBean label = albumList.get(position);
        AVLog.print("ThumbURL-->"+label.imgThumbUrl);
        Picasso.with(mContext).load(label.imgThumbUrl).into(holder.ivGridImage);
        /*holder.ivGridImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, position, Toast.LENGTH_SHORT).show();
            }
        });*/
        setAnimation(holder.itemContainer, position);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


    class GridItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivGridImage;
        public LinearLayout itemContainer;

        public GridItemViewHolder(View itemView) {
            super(itemView);
            ivGridImage = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            itemContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
