package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by konghang on 16/3/3.
 */
public class ShopDetailLite implements Serializable {

    //合作方商户唯一 ID
    private String shop_id;

    //百度商户 ID
    private String baidu_shop_id;

    //商户名称
    private String name;

    //商户状态,'1'为营业中，'3'休息中，'5'为歇业，'9'为下线
    private String status;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getBaidu_shop_id() {
        return baidu_shop_id;
    }

    public void setBaidu_shop_id(String baidu_shop_id) {
        this.baidu_shop_id = baidu_shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopDetailLite that = (ShopDetailLite) o;

        if (shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null) return false;
        if (baidu_shop_id != null ? !baidu_shop_id.equals(that.baidu_shop_id) : that.baidu_shop_id != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (baidu_shop_id != null ? baidu_shop_id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopDetailLite{" +
                "shop_id='" + shop_id + '\'' +
                ", baidu_shop_id='" + baidu_shop_id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
