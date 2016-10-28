package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-28.
 */
public class OrderDelivery implements Serializable {

    private String pickup_time;  //取餐时间
    private String atshop_time;  //到店时间
    private String delivery_time;  //送餐时间
    private String delivery_phone;  //骑士手机号
    private String finished_time;  //完成时间
    private String confirm_time;  //确认时间

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getAtshop_time() {
        return atshop_time;
    }

    public void setAtshop_time(String atshop_time) {
        this.atshop_time = atshop_time;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getDelivery_phone() {
        return delivery_phone;
    }

    public void setDelivery_phone(String delivery_phone) {
        this.delivery_phone = delivery_phone;
    }

    public String getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(String finished_time) {
        this.finished_time = finished_time;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "pickup_time='" + pickup_time + '\'' +
                ", atshop_time='" + atshop_time + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                ", delivery_phone='" + delivery_phone + '\'' +
                ", finished_time='" + finished_time + '\'' +
                ", confirm_time='" + confirm_time + '\'' +
                '}';
    }
}
