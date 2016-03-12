package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-3-12.
 */
public class Picture implements Serializable {

    //图片类型，参见附录商户资质图片类型对照表
    private int type;

    //图片地址
    private String url;

    //备注
    private String desc;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (type != picture.type) return false;
        if (url != null ? !url.equals(picture.url) : picture.url != null) return false;
        return desc != null ? desc.equals(picture.desc) : picture.desc == null;

    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "type=" + type +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
