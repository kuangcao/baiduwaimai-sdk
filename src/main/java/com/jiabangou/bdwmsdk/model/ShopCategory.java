package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * 门店分类
 * Created by konghang on 16/3/3.
 */
@JSONType
public class ShopCategory implements Serializable {
    //一级分类
    private String category1;

    //二级分类
    private String category2;

    //三级分类
    private String category3;

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopCategory that = (ShopCategory) o;

        if (category1 != null ? !category1.equals(that.category1) : that.category1 != null) return false;
        if (category2 != null ? !category2.equals(that.category2) : that.category2 != null) return false;
        return category3 != null ? category3.equals(that.category3) : that.category3 == null;

    }

    @Override
    public int hashCode() {
        int result = category1 != null ? category1.hashCode() : 0;
        result = 31 * result + (category2 != null ? category2.hashCode() : 0);
        result = 31 * result + (category3 != null ? category3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopCategory{" +
                "category1='" + category1 + '\'' +
                ", category2='" + category2 + '\'' +
                ", category3='" + category3 + '\'' +
                '}';
    }
}
