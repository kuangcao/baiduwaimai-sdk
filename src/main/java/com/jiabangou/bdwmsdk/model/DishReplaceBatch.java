package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-3-3.
 */
@JSONType
public class DishReplaceBatch implements Serializable {

    // 合作方商户唯一 ID
    private String shop_id;

    //菜品分类
    private List<Category> category;

    //菜品
    private List<Dish> dishes;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishReplaceBatch that = (DishReplaceBatch) o;

        if (shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return dishes != null ? dishes.equals(that.dishes) : that.dishes == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DishReplaceBatch{" +
                "shop_id='" + shop_id + '\'' +
                ", category=" + category +
                ", dishes=" + dishes +
                '}';
    }
}
