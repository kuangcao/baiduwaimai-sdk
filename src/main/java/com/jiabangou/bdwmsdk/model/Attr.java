package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-3-3.
 */
public class Attr implements Serializable {

    //属性名称
    private String name;

    //属性值
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attr attr = (Attr) o;

        if (name != null ? !name.equals(attr.name) : attr.name != null) return false;
        return value != null ? value.equals(attr.value) : attr.value == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
