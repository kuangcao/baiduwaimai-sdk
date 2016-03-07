package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class CategoryUpdate implements Serializable {

    // 合作方商户唯一 ID
    private String shop_id;
    // 原分类名称
    private String old_name;
    // 名称
    private String name;

    //降序排序，大于0
    private int rank;

    public String getOld_name() {
        return old_name;
    }

    public void setOld_name(String old_name) {
        this.old_name = old_name;
    }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
