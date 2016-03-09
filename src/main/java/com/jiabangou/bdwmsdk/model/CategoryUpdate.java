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
    private Integer rank;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryUpdate that = (CategoryUpdate) o;

        if (shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null) return false;
        if (old_name != null ? !old_name.equals(that.old_name) : that.old_name != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return rank != null ? rank.equals(that.rank) : that.rank == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (old_name != null ? old_name.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryUpdate{" +
                "shop_id='" + shop_id + '\'' +
                ", old_name='" + old_name + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
