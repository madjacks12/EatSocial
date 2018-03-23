package com.mdjdev.eatsocial.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Matthew on 3/16/2018.
 */

public class ListAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurants;
    private String[] mFriends;

    public ListAdapter(Context mContext, int resource, String[] mRestaurants, String[] mFriends) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mFriends = mFriends;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String friend = mFriends[position];
        return String.format("%s \n %s", restaurant, friend);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}
