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

    public Friends() {}

    public Friends(String name, String id) {
        this.name = name;
        this.id = id;
}

    public String getName() {
        return name;
    }

    public String id() {
        return id;
    }
}