package com.jiabangou.bdwmsdk.model;

/**
 * Created by konghang on 16/3/3.
 */
public class ShopDetail extends Shop {

    //合作方商户唯一 ID
    private String baidu_shop_id;

    //商户状态,'1'为营业中，'3'为歇业，'9'为下线
    private String status;

    public String getBaidu_shop_id() {
        return baidu_shop_id;
    }

    public void setBaidu_shop_id(String baidu_shop_id) {
        this.baidu_shop_id = baidu_shop_id;
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
        if (!super.equals(o)) return false;

        ShopDetail that = (ShopDetail) o;

        if (baidu_shop_id != null ? !baidu_shop_id.equals(that.baidu_shop_id) : that.baidu_shop_id != null)
            return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (baidu_shop_id != null ? baidu_shop_id.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopDetail{" +
                "baidu_shop_id='" + baidu_shop_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
