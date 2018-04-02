package com.mdjdev.eatsocial.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Matthew on 3/30/2018.
 */

public class CheckInAdapter extends ArrayAdapter{
    private Context mContext;
    private ArrayList<String>names = new ArrayList<>();
    private ArrayList<String>latitude = new ArrayList<>();
    private ArrayList<String>longitude = new ArrayList<>();


    public CheckInAdapter(Context mContext, int resource, ArrayList<String> names, ArrayList<String> latitude, ArrayList<String> longitude) {
        super(mContext, resource);
        this.mContext = mContext;
        this.names = names;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public Object getItem(int position) {
        String name = names.get(position);
        return name;
    }

    @Override
    public int getCount() {
        return names.size();
    }

}

