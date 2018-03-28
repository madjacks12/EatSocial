package com.mdjdev.eatsocial.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Matthew on 3/25/2018.
 */

@Parcel
public class Friends {
    private String name;
    private String id;
    private ArrayList<CheckIn> checkIn;

    public Friends() {}

    public Friends(String name, String id, ArrayList checkIn) {
        this.name = name;
        this.id = id;
        this.checkIn = checkIn;
}

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<CheckIn> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(ArrayList<CheckIn> checkIn) {
        this.checkIn = checkIn;
    }
}