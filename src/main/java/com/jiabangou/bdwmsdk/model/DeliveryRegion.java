package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-3-2.
 */
public class DeliveryRegion implements Serializable {
    //配送区域名称，最长不超过10个汉字
    private String name;
    //配送区域经纬度
    private List<List<Region>> region;
    //配送时长，单位分钟
    private String delivery_time;
    //配送费，单位：分
    private String delivery_fee;


    public List<List<Region>> getRegion() {
        return region;
    }

    public void setRegion(List<List<Region>> region) {
        this.region = region;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryRegion that = (DeliveryRegion) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (delivery_time != null ? !delivery_time.equals(that.delivery_time) : that.delivery_time != null)
            return false;
        return delivery_fee != null ? delivery_fee.equals(that.delivery_fee) : that.delivery_fee == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (delivery_time != null ? delivery_time.hashCode() : 0);
        result = 31 * result + (delivery_fee != null ? delivery_fee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeliveryRegion{" +
                "name='" + name + '\'' +
                ", region=" + region +
                ", delivery_time='" + delivery_time + '\'' +
                ", delivery_fee='" + delivery_fee + '\'' +
                '}';
    }
}
