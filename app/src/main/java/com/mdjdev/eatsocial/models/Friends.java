package com.mdjdev.eatsocial.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Matthew on 3/25/2018.
 */

@Parcel
public class Friends {
    private String name;
    private ArrayList<String> checkIns = new ArrayList<>();

    public Friends() {}

    public Friends(String name, ArrayList<String> checkIns) {
        this.name = name;
        this.checkIns = checkIns;
}

    public String getName() {
        return name;
    }

    public ArrayList<String> getCheckIns() {
        return checkIns;
    }
}