package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class Coord implements Serializable {
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
