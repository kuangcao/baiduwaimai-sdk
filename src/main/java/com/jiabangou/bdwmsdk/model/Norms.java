package com.jiabangou.bdwmsdk.model;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

/**
 * Created by wanglei on 16-3-3.
 */
public class Norms implements Serializable {

    //规格名称(不必填)
    private String name;

    //规格名称值
    private String value;

    //价格，单位：分
    private Integer price;

    //菜品库存设置，每天固定时间，设置库存数量(不必填)
    private List<Threshold> threshold;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Threshold> getThreshold() {
        return threshold;
    }

    public void setThreshold(List<Threshold> threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Norms norms = (Norms) o;

        if (name != null ? !name.equals(norms.name) : norms.name != null) return false;
        if (value != null ? !value.equals(norms.value) : norms.value != null) return false;
        if (price != null ? !price.equals(norms.price) : norms.price != null) return false;
        return threshold != null ? threshold.equals(norms.threshold) : norms.threshold == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Norms{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", price=" + price +
                ", threshold=" + threshold +
                '}';
    }
}
