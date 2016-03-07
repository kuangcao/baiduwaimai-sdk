package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class CategoryGet implements Serializable {

    // 合作方商户唯一 ID
    private String shop_id;
    // 名称
    private String name;


    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
