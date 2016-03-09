package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wanglei on 16-3-3.
 */
public class Dish implements Serializable {

    // 合作方商户唯一 ID
    private String shop_id;

    // 名称
    private String name;

    //菜品id
    private String dish_id;

    //条形码编号(不必填)
    private String upc;

    //菜品价格，单位：分
    private Integer price;

    //菜品图片(不必填)
    private String pic;

    //最小起订份数
    private Integer min_order_num;

    //单份所需餐盒数
    private Integer package_box_num;

    //描述（不必填）
    private String description;

    //可售时间key为 1 表示周一，为，7 表示周日，"*" 表示周一到周日(不必填)
    private HashMap<String, List<AvailableTime>> available_times;

    //菜品库存设置，每天固定时间，设置库存数量(不必填)
    private List<Threshold> threshold;

    //菜品分类
    private List<Category> category;

    //菜品规格(不必填)
    private List<Norms> norms;

    //菜品属性 （不必填）
    private List<Attr> attr;

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

    public String getDish_id() {
        return dish_id;
    }

    public void setDish_id(String dish_id) {
        this.dish_id = dish_id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getMin_order_num() {
        return min_order_num;
    }

    public void setMin_order_num(Integer min_order_num) {
        this.min_order_num = min_order_num;
    }

    public Integer getPackage_box_num() {
        return package_box_num;
    }

    public void setPackage_box_num(Integer package_box_num) {
        this.package_box_num = package_box_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, List<AvailableTime>> getAvailable_times() {
        return available_times;
    }

    public void setAvailable_times(HashMap<String, List<AvailableTime>> available_times) {
        this.available_times = available_times;
    }

    public List<Threshold> getThreshold() {
        return threshold;
    }

    public void setThreshold(List<Threshold> threshold) {
        this.threshold = threshold;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Norms> getNorms() {
        return norms;
    }

    public void setNorms(List<Norms> norms) {
        this.norms = norms;
    }

    public List<Attr> getAttr() {
        return attr;
    }

    public void setAttr(List<Attr> attr) {
        this.attr = attr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (shop_id != null ? !shop_id.equals(dish.shop_id) : dish.shop_id != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (dish_id != null ? !dish_id.equals(dish.dish_id) : dish.dish_id != null) return false;
        if (upc != null ? !upc.equals(dish.upc) : dish.upc != null) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        if (pic != null ? !pic.equals(dish.pic) : dish.pic != null) return false;
        if (min_order_num != null ? !min_order_num.equals(dish.min_order_num) : dish.min_order_num != null)
            return false;
        if (package_box_num != null ? !package_box_num.equals(dish.package_box_num) : dish.package_box_num != null)
            return false;
        if (description != null ? !description.equals(dish.description) : dish.description != null) return false;
        if (available_times != null ? !available_times.equals(dish.available_times) : dish.available_times != null)
            return false;
        if (threshold != null ? !threshold.equals(dish.threshold) : dish.threshold != null) return false;
        if (category != null ? !category.equals(dish.category) : dish.category != null) return false;
        if (norms != null ? !norms.equals(dish.norms) : dish.norms != null) return false;
        return attr != null ? attr.equals(dish.attr) : dish.attr == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dish_id != null ? dish_id.hashCode() : 0);
        result = 31 * result + (upc != null ? upc.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (min_order_num != null ? min_order_num.hashCode() : 0);
        result = 31 * result + (package_box_num != null ? package_box_num.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (available_times != null ? available_times.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (norms != null ? norms.hashCode() : 0);
        result = 31 * result + (attr != null ? attr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "shop_id='" + shop_id + '\'' +
                ", name='" + name + '\'' +
                ", dish_id='" + dish_id + '\'' +
                ", upc='" + upc + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", min_order_num=" + min_order_num +
                ", package_box_num=" + package_box_num +
                ", description='" + description + '\'' +
                ", available_times=" + available_times +
                ", threshold=" + threshold +
                ", category=" + category +
                ", norms=" + norms +
                ", attr=" + attr +
                '}';
    }
}
