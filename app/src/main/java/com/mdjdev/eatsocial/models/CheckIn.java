package com.mdjdev.eatsocial.models;

import org.parceler.Parcel;

/**
 * Created by Matthew on 3/27/2018.
 */

@Parcel
public class CheckIn {
    private String placeName;
    private String placeId;
    private String placeLat;
    private String placeLong;
    private String city;
    private String state;

    public CheckIn() {}

    public CheckIn(String placeName, String placeId, String placeLat, String placeLong) {
        this.placeName = placeName;
        this.placeId = placeId;
        this.placeLat = placeLat;
        this.placeLong = placeLong;
//        this.city = city;
//        this.state = state;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPlaceLat() {
        return placeLat;
    }

    public String getPlaceLong() {
        return placeLong;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setPlaceLat(String placeLat) {
        this.placeLat = placeLat;
    }

    public void setPlaceLong(String placeLong) {
        this.placeLong = placeLong;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}