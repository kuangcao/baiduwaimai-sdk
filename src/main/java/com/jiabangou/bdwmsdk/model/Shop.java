package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * 店铺
 * Created by freeway on 16/3/8.
 */
public class Shop implements Serializable {

    private String id;
    private String name;
    private String baidu_shop_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaidu_shop_id() {
        return baidu_shop_id;
    }

    public void setBaidu_shop_id(String baidu_shop_id) {
        this.baidu_shop_id = baidu_shop_id;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", baidu_shop_id='" + baidu_shop_id + '\'' +
                '}';
    }
}
