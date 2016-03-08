package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class Discount implements Serializable {

    private String type;
    private String activity_id;
    private String rule_id;
    private int fee;
    private int baidu_rate;
    private int shop_rate;
    private int agent_rate;
    private int logistics_rate;
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getRule_id() {
        return rule_id;
    }

    public void setRule_id(String rule_id) {
        this.rule_id = rule_id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getBaidu_rate() {
        return baidu_rate;
    }

    public void setBaidu_rate(int baidu_rate) {
        this.baidu_rate = baidu_rate;
    }

    public int getShop_rate() {
        return shop_rate;
    }

    public void setShop_rate(int shop_rate) {
        this.shop_rate = shop_rate;
    }

    public int getAgent_rate() {
        return agent_rate;
    }

    public void setAgent_rate(int agent_rate) {
        this.agent_rate = agent_rate;
    }

    public int getLogistics_rate() {
        return logistics_rate;
    }

    public void setLogistics_rate(int logistics_rate) {
        this.logistics_rate = logistics_rate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "type='" + type + '\'' +
                ", activity_id='" + activity_id + '\'' +
                ", rule_id='" + rule_id + '\'' +
                ", fee=" + fee +
                ", baidu_rate=" + baidu_rate +
                ", shop_rate=" + shop_rate +
                ", agent_rate=" + agent_rate +
                ", logistics_rate=" + logistics_rate +
                ", desc='" + desc + '\'' +
                '}';
    }
}
