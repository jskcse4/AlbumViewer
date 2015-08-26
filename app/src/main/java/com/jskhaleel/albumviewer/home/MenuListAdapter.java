package com.jskhaleel.albumviewer.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.jskhaleel.albumviewer.R;
import com.jskhaleel.albumviewer.ui.AVTextVew;

import java.util.ArrayList;

public class MenuListAdapter extends BaseAdapter{
    private final LayoutInflater mInflator;
    private ArrayList<MenuItemView> mItems;
    private Context context;
    private OnMenuClickListener onMenuClickListener;

    public MenuListAdapter(ArrayList<String> menuArray, Context context, OnMenuClickListener onMenuClickListener) {
        this.mItems = getItems(menuArray);
        this.context = context;
        mInflator = LayoutInflater.from(context);
        this.onMenuClickListener = onMenuClickListener;
    }

    private ArrayList<MenuItemView> getItems(ArrayList<String> menuList) {
        ArrayList<MenuItemView> list = new ArrayList<>();
        for (String item : menuList) {
            list.add(new MenuItemView(item));
        }
        return list;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public MenuItemView getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(convertView, parent);
    }

    private class MenuItemView {
        String item;
        public MenuItemView(String item) {
            this.item = item;
        }

        public View getView(View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = mInflator.inflate(R.layout.left_menu_item, parent, false);
            }
            final RelativeLayout menuTextLayout = (RelativeLayout) convertView.findViewById(R.id.rl_menu_item);
            final AVTextVew menuText = (AVTextVew) convertView.findViewById(R.id.menu_item);

            menuText.setText(item);
            menuTextLayout.setTag(item);

            menuTextLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onMenuClickListener != null) {
                        onMenuClickListener.onMenuClick(menuTextLayout.getTag().toString());
                    }
                }
            });

            return convertView;
        }
    }

    interface OnMenuClickListener {
        void onMenuClick(String tag);
    }
}
