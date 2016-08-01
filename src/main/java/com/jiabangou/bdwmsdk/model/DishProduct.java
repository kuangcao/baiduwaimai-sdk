package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.util.List;
@JSONType
public class DishProduct implements Serializable {

    private Category category;
    private List<DishDetail> products;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<DishDetail> getProducts() {
        return products;
    }

    public void setProducts(List<DishDetail> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishProduct that = (DishProduct) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return products != null ? products.equals(that.products) : that.products == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DishProduct{" +
                "category=" + category +
                ", products=" + products +
                '}';
    }
}
