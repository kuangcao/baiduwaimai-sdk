package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetail implements Serializable {

    private String source;
    private Order order;
    private ShopLite shop;
    private User user;
    private List<Discount> discount;
    private List<Product> products;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShopLite getShop() {
        return shop;
    }

    public void setShop(ShopLite shop) {
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Discount> getDiscount() {
        return discount;
    }

    public void setDiscount(List<Discount> discount) {
        this.discount = discount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetail that = (OrderDetail) o;

        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (shop != null ? !shop.equals(that.shop) : that.shop != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
        return products != null ? products.equals(that.products) : that.products == null;

    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "source='" + source + '\'' +
                ", order=" + order +
                ", shop=" + shop +
                ", user=" + user +
                ", discount=" + discount +
                ", products=" + products +
                '}';
    }
}
