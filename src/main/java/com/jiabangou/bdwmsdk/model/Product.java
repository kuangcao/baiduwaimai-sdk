package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String product_id;
    private String upc;
    private String product_name;
    private int product_price;
    private int product_amount;
    private int product_fee;
    private int package_price;
    private double package_amount;
    private int package_fee;
    private int total_fee;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    public int getProduct_fee() {
        return product_fee;
    }

    public void setProduct_fee(int product_fee) {
        this.product_fee = product_fee;
    }

    public int getPackage_price() {
        return package_price;
    }

    public void setPackage_price(int package_price) {
        this.package_price = package_price;
    }

    public double getPackage_amount() {
        return package_amount;
    }

    public void setPackage_amount(double package_amount) {
        this.package_amount = package_amount;
    }

    public int getPackage_fee() {
        return package_fee;
    }

    public void setPackage_fee(int package_fee) {
        this.package_fee = package_fee;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", upc='" + upc + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_amount=" + product_amount +
                ", product_fee=" + product_fee +
                ", package_price=" + package_price +
                ", package_amount=" + package_amount +
                ", package_fee=" + package_fee +
                ", total_fee=" + total_fee +
                '}';
    }
}
