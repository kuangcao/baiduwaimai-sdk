package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * Created by wanglei on 16-3-3.
 */
@JSONType
public class Norms implements Serializable {

    private String name;
    private String dish_norms_id;
    private String dish_id;
    private String wid;
    private String name_value;
    private String current_price;
    private String discount;
    private Integer store_num;
    private Integer left_num;
    private String status;
    private String  create_time;
    private String  supplier_dish_norms_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDish_norms_id() {
        return dish_norms_id;
    }

    public void setDish_norms_id(String dish_norms_id) {
        this.dish_norms_id = dish_norms_id;
    }

    public String getDish_id() {
        return dish_id;
    }

    public void setDish_id(String dish_id) {
        this.dish_id = dish_id;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName_value() {
        return name_value;
    }

    public void setName_value(String name_value) {
        this.name_value = name_value;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getStore_num() {
        return store_num;
    }

    public void setStore_num(Integer store_num) {
        this.store_num = store_num;
    }

    public Integer getLeft_num() {
        return left_num;
    }

    public void setLeft_num(Integer left_num) {
        this.left_num = left_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSupplier_dish_norms_id() {
        return supplier_dish_norms_id;
    }

    public void setSupplier_dish_norms_id(String supplier_dish_norms_id) {
        this.supplier_dish_norms_id = supplier_dish_norms_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Norms norms = (Norms) o;

        if (name != null ? !name.equals(norms.name) : norms.name != null) return false;
        if (dish_norms_id != null ? !dish_norms_id.equals(norms.dish_norms_id) : norms.dish_norms_id != null)
            return false;
        if (dish_id != null ? !dish_id.equals(norms.dish_id) : norms.dish_id != null) return false;
        if (wid != null ? !wid.equals(norms.wid) : norms.wid != null) return false;
        if (name_value != null ? !name_value.equals(norms.name_value) : norms.name_value != null) return false;
        if (current_price != null ? !current_price.equals(norms.current_price) : norms.current_price != null)
            return false;
        if (discount != null ? !discount.equals(norms.discount) : norms.discount != null) return false;
        if (store_num != null ? !store_num.equals(norms.store_num) : norms.store_num != null) return false;
        if (left_num != null ? !left_num.equals(norms.left_num) : norms.left_num != null) return false;
        if (status != null ? !status.equals(norms.status) : norms.status != null) return false;
        if (create_time != null ? !create_time.equals(norms.create_time) : norms.create_time != null) return false;
        return supplier_dish_norms_id != null ? supplier_dish_norms_id.equals(norms.supplier_dish_norms_id) : norms.supplier_dish_norms_id == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dish_norms_id != null ? dish_norms_id.hashCode() : 0);
        result = 31 * result + (dish_id != null ? dish_id.hashCode() : 0);
        result = 31 * result + (wid != null ? wid.hashCode() : 0);
        result = 31 * result + (name_value != null ? name_value.hashCode() : 0);
        result = 31 * result + (current_price != null ? current_price.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (store_num != null ? store_num.hashCode() : 0);
        result = 31 * result + (left_num != null ? left_num.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (supplier_dish_norms_id != null ? supplier_dish_norms_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Norms{" +
                "name='" + name + '\'' +
                ", dish_norms_id='" + dish_norms_id + '\'' +
                ", dish_id='" + dish_id + '\'' +
                ", wid='" + wid + '\'' +
                ", name_value='" + name_value + '\'' +
                ", current_price='" + current_price + '\'' +
                ", discount='" + discount + '\'' +
                ", store_num=" + store_num +
                ", left_num=" + left_num +
                ", status='" + status + '\'' +
                ", create_time='" + create_time + '\'' +
                ", supplier_dish_norms_id='" + supplier_dish_norms_id + '\'' +
                '}';
    }
}
