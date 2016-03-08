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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        if (fee != discount.fee) return false;
        if (baidu_rate != discount.baidu_rate) return false;
        if (shop_rate != discount.shop_rate) return false;
        if (agent_rate != discount.agent_rate) return false;
        if (logistics_rate != discount.logistics_rate) return false;
        if (type != null ? !type.equals(discount.type) : discount.type != null) return false;
        if (activity_id != null ? !activity_id.equals(discount.activity_id) : discount.activity_id != null)
            return false;
        if (rule_id != null ? !rule_id.equals(discount.rule_id) : discount.rule_id != null) return false;
        return desc != null ? desc.equals(discount.desc) : discount.desc == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (activity_id != null ? activity_id.hashCode() : 0);
        result = 31 * result + (rule_id != null ? rule_id.hashCode() : 0);
        result = 31 * result + fee;
        result = 31 * result + baidu_rate;
        result = 31 * result + shop_rate;
        result = 31 * result + agent_rate;
        result = 31 * result + logistics_rate;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
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
