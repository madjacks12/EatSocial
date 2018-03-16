package com.mdjdev.eatsocial;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Matthew on 3/16/2018.
 */

public class ListAdapter extends ArrayAdapter {

    public ListAdapter(Context mContext, int resource, String[] mRestaurants, String[] mFriends) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}
