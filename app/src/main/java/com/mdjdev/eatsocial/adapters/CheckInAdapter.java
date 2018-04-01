package com.mdjdev.eatsocial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.models.CheckIn;
import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.ui.FriendDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;

/**
 * Created by Matthew on 3/30/2018.
 */

//    private Context mContext;
//    private ArrayList<CheckIn> checkIns = new ArrayList<>();
//    private String[] mCuisines;
//
//    public CheckInAdapter(Context mContext, int resource, ArrayList checkIns) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.checkIns = checkIns;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        ArrayList<CheckIn> checkIn = checkIns[position];
//        String cuisine = mCuisines[position];
//        return String.format("%s \nServes great: %s", restaurant, cuisine);
//    }
//
//    @Override
//    public int getCount() {
//        return mRestaurants.length;
//    }

