package com.jiabangou.bdwmsdk.model;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private String source;
    private Order order;
    private Shop shop;
    private User user;
    private List<Discount> discount;
    private List<Product> products;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
