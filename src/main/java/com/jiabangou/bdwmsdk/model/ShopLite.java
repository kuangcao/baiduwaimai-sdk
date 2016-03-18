package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by konghang on 16/3/3.
 */
public class ShopLite implements Serializable {
    //合作方商户唯一 ID
    private String id;

    //商户名称
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopLite shopLite = (ShopLite) o;

        if (id != null ? !id.equals(shopLite.id) : shopLite.id != null) return false;
        return name != null ? name.equals(shopLite.name) : shopLite.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopLite{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
