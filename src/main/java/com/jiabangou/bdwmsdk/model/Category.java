package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class Category implements Serializable {

    // 合作方商户唯一 ID
    private String shop_id;

    // 名称
    private String name;

    //降序排序，大于0
    private Integer rank;

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

        Category category = (Category) o;

        if (shop_id != null ? !shop_id.equals(category.shop_id) : category.shop_id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return rank != null ? rank.equals(category.rank) : category.rank == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "shop_id='" + shop_id + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
