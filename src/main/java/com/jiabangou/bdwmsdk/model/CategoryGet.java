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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryGet that = (CategoryGet) o;

        if (shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryGet{" +
                "shop_id='" + shop_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
