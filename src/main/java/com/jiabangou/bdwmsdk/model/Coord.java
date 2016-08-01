package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
@JSONType
public class Coord implements Serializable {

    //送餐地址百度经度
    private String longitude;
    //送餐地址百度纬度
    private String latitude;
    //送餐地址高德经度
    private String coord_amap_longitude;
    //送餐地址高德纬度
    private String coord_amap_latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCoord_amap_longitude() {
        return coord_amap_longitude;
    }

    public void setCoord_amap_longitude(String coord_amap_longitude) {
        this.coord_amap_longitude = coord_amap_longitude;
    }

    public String getCoord_amap_latitude() {
        return coord_amap_latitude;
    }

    public void setCoord_amap_latitude(String coord_amap_latitude) {
        this.coord_amap_latitude = coord_amap_latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (longitude != null ? !longitude.equals(coord.longitude) : coord.longitude != null) return false;
        if (latitude != null ? !latitude.equals(coord.latitude) : coord.latitude != null) return false;
        if (coord_amap_longitude != null ? !coord_amap_longitude.equals(coord.coord_amap_longitude) : coord.coord_amap_longitude != null)
            return false;
        return coord_amap_latitude != null ? coord_amap_latitude.equals(coord.coord_amap_latitude) : coord.coord_amap_latitude == null;

    }

    @Override
    public int hashCode() {
        int result = longitude != null ? longitude.hashCode() : 0;
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (coord_amap_longitude != null ? coord_amap_longitude.hashCode() : 0);
        result = 31 * result + (coord_amap_latitude != null ? coord_amap_latitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", coord_amap_longitude='" + coord_amap_longitude + '\'' +
                ", coord_amap_latitude='" + coord_amap_latitude + '\'' +
                '}';
    }
}
