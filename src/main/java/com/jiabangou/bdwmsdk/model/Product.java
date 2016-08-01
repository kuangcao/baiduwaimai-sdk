package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
@JSONType
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (product_price != product.product_price) return false;
        if (product_amount != product.product_amount) return false;
        if (product_fee != product.product_fee) return false;
        if (package_price != product.package_price) return false;
        if (Double.compare(product.package_amount, package_amount) != 0) return false;
        if (package_fee != product.package_fee) return false;
        if (total_fee != product.total_fee) return false;
        if (product_id != null ? !product_id.equals(product.product_id) : product.product_id != null) return false;
        if (upc != null ? !upc.equals(product.upc) : product.upc != null) return false;
        return product_name != null ? product_name.equals(product.product_name) : product.product_name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = product_id != null ? product_id.hashCode() : 0;
        result = 31 * result + (upc != null ? upc.hashCode() : 0);
        result = 31 * result + (product_name != null ? product_name.hashCode() : 0);
        result = 31 * result + product_price;
        result = 31 * result + product_amount;
        result = 31 * result + product_fee;
        result = 31 * result + package_price;
        temp = Double.doubleToLongBits(package_amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + package_fee;
        result = 31 * result + total_fee;
        return result;
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
