package com.mdjdev.eatsocial.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 3/25/2018.
 */

@Parcel
public class Friends {
    private String name;
    private String id;
    private List<CheckIn> checkIn = new ArrayList<>();

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

    public List<CheckIn> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(List<CheckIn> checkIn) {
        this.checkIn = checkIn;
    }
}