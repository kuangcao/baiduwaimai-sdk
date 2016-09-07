package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-3-3.
 */
@JSONType
public class DishDetail implements Serializable {

    // 名称
    private String name;

    //菜品id
    private String dish_id;

    //条形码编号(不必填)
    private String upc;

    //菜品价格，单位：分
    private Integer price;

    //菜品图片(不必填)
    private String pic;

    //最小起订份数
    private Integer min_order_num;

    //单份所需餐盒数
    private Integer package_box_num;

    //描述（不必填）
    private String description;

    //菜品可售时间
    //由于返回的菜品可售时间结构不固定所以用Object对象接收
    //可售时间七天都设置的时候返回的结构为List<List<AvailableTime>>
    //可售时间只设置其中几天的时候返回的结构为HashMap<String, List<AvailableTime>>
    private Object available_times;

    //菜品排序
    private Integer rank;

    //百度dish_id
    private String baidu_dish_id;

    //菜品状态
    private Integer status;

    private List<Norms> normses;

    private List<Attr> attrs;

    private String wid;

    private Integer left_num;

    public List<Norms> getNormses() {
        return normses;
    }

    public void setNormses(List<Norms> normses) {
        this.normses = normses;
    }

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public Integer getLeft_num() {
        return left_num;
    }

    public void setLeft_num(Integer left_num) {
        this.left_num = left_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDish_id() {
        return dish_id;
    }

    public void setDish_id(String dish_id) {
        this.dish_id = dish_id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getMin_order_num() {
        return min_order_num;
    }

    public void setMin_order_num(Integer min_order_num) {
        this.min_order_num = min_order_num;
    }

    public Integer getPackage_box_num() {
        return package_box_num;
    }

    public void setPackage_box_num(Integer package_box_num) {
        this.package_box_num = package_box_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAvailable_times() {
        return available_times;
    }

    public void setAvailable_times(Object available_times) {
        this.available_times = available_times;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getBaidu_dish_id() {
        return baidu_dish_id;
    }

    public void setBaidu_dish_id(String baidu_dish_id) {
        this.baidu_dish_id = baidu_dish_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishDetail that = (DishDetail) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dish_id != null ? !dish_id.equals(that.dish_id) : that.dish_id != null) return false;
        if (upc != null ? !upc.equals(that.upc) : that.upc != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (pic != null ? !pic.equals(that.pic) : that.pic != null) return false;
        if (min_order_num != null ? !min_order_num.equals(that.min_order_num) : that.min_order_num != null)
            return false;
        if (package_box_num != null ? !package_box_num.equals(that.package_box_num) : that.package_box_num != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (available_times != null ? !available_times.equals(that.available_times) : that.available_times != null)
            return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (baidu_dish_id != null ? !baidu_dish_id.equals(that.baidu_dish_id) : that.baidu_dish_id != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (normses != null ? !normses.equals(that.normses) : that.normses != null) return false;
        if (attrs != null ? !attrs.equals(that.attrs) : that.attrs != null) return false;
        if (wid != null ? !wid.equals(that.wid) : that.wid != null) return false;
        return left_num != null ? left_num.equals(that.left_num) : that.left_num == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dish_id != null ? dish_id.hashCode() : 0);
        result = 31 * result + (upc != null ? upc.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (min_order_num != null ? min_order_num.hashCode() : 0);
        result = 31 * result + (package_box_num != null ? package_box_num.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (available_times != null ? available_times.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (baidu_dish_id != null ? baidu_dish_id.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (normses != null ? normses.hashCode() : 0);
        result = 31 * result + (attrs != null ? attrs.hashCode() : 0);
        result = 31 * result + (wid != null ? wid.hashCode() : 0);
        result = 31 * result + (left_num != null ? left_num.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DishDetail{" +
                "name='" + name + '\'' +
                ", dish_id='" + dish_id + '\'' +
                ", upc='" + upc + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", min_order_num=" + min_order_num +
                ", package_box_num=" + package_box_num +
                ", description='" + description + '\'' +
                ", available_times=" + available_times +
                ", rank=" + rank +
                ", baidu_dish_id='" + baidu_dish_id + '\'' +
                ", status=" + status +
                ", normses=" + normses +
                ", attrs=" + attrs +
                ", wid='" + wid + '\'' +
                ", left_num=" + left_num +
                '}';
    }
}
