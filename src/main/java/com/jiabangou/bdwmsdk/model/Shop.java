package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by konghang on 16/3/3.
 */
public class Shop implements Serializable {
    //合作方商户唯一 ID
    private String shop_id;

    //商户名称
    private String name;

    //商户图片(不必填)
    private String shop_logo;

    //商户所在省名称
    private String province;

    //商户所在市名称
    private String city;

    //商户所在区县
    private String county;

    //商户地址
    private String address;

    //品牌，例如肯德基(不必填)
    private String brand;

    //分类集
    private List<ShopCategory> categorys;

    //商户电话，座机必须填写区号
    private String phone;

    //客服电话
    private String service_phone;

    //经度，为空时自动根据 address 获取
    private String longitude;

    //纬度
    private String latitude;

    //坐标类型，可选值：bdll(百度经纬度)；amap(高德经纬度), 默认是bdll(不必填)
    private String coord_type;

    //配送区域信息
    private List<DeliveryRegion> delivery_region;

    //营业时间，如果开始时间大于结束时间则表示跨天
    private List<BussinessTime> business_time;

    //提前下单时间，单位分钟，预留字段暂不生效(不必填)
    private Integer book_ahead_time;

    //是否可以提供发票，1：是 2：否
    private Integer invoice_support;

    //外卖起送价，单位：分
    private Integer min_order_price;

    //餐盒费，单位：分
    private Integer package_box_price;

    //订单阈值设置(固定时间自动设置库存)（不必填）
    private List<Threshold> threshold;

    //商户代码
    private String shopCode;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop_logo() {
        return shop_logo;
    }

    public void setShop_logo(String shop_logo) {
        this.shop_logo = shop_logo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<ShopCategory> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<ShopCategory> categorys) {
        this.categorys = categorys;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCoord_type() {
        return coord_type;
    }

    public void setCoord_type(String coord_type) {
        this.coord_type = coord_type;
    }

    public List<DeliveryRegion> getDelivery_region() {
        return delivery_region;
    }

    public void setDelivery_region(List<DeliveryRegion> delivery_region) {
        this.delivery_region = delivery_region;
    }

    public List<BussinessTime> getBusiness_time() {
        return business_time;
    }

    public void setBusiness_time(List<BussinessTime> business_time) {
        this.business_time = business_time;
    }

    public Integer getBook_ahead_time() {
        return book_ahead_time;
    }

    public void setBook_ahead_time(Integer book_ahead_time) {
        this.book_ahead_time = book_ahead_time;
    }

    public Integer getInvoice_support() {
        return invoice_support;
    }

    public void setInvoice_support(Integer invoice_support) {
        this.invoice_support = invoice_support;
    }

    public Integer getMin_order_price() {
        return min_order_price;
    }

    public void setMin_order_price(Integer min_order_price) {
        this.min_order_price = min_order_price;
    }

    public Integer getPackage_box_price() {
        return package_box_price;
    }

    public void setPackage_box_price(Integer package_box_price) {
        this.package_box_price = package_box_price;
    }

    public List<Threshold> getThreshold() {
        return threshold;
    }

    public void setThreshold(List<Threshold> threshold) {
        this.threshold = threshold;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shop_id != null ? !shop_id.equals(shop.shop_id) : shop.shop_id != null) return false;
        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        if (shop_logo != null ? !shop_logo.equals(shop.shop_logo) : shop.shop_logo != null) return false;
        if (province != null ? !province.equals(shop.province) : shop.province != null) return false;
        if (city != null ? !city.equals(shop.city) : shop.city != null) return false;
        if (county != null ? !county.equals(shop.county) : shop.county != null) return false;
        if (address != null ? !address.equals(shop.address) : shop.address != null) return false;
        if (brand != null ? !brand.equals(shop.brand) : shop.brand != null) return false;
        if (categorys != null ? !categorys.equals(shop.categorys) : shop.categorys != null) return false;
        if (phone != null ? !phone.equals(shop.phone) : shop.phone != null) return false;
        if (service_phone != null ? !service_phone.equals(shop.service_phone) : shop.service_phone != null)
            return false;
        if (longitude != null ? !longitude.equals(shop.longitude) : shop.longitude != null) return false;
        if (latitude != null ? !latitude.equals(shop.latitude) : shop.latitude != null) return false;
        if (coord_type != null ? !coord_type.equals(shop.coord_type) : shop.coord_type != null) return false;
        if (delivery_region != null ? !delivery_region.equals(shop.delivery_region) : shop.delivery_region != null)
            return false;
        if (business_time != null ? !business_time.equals(shop.business_time) : shop.business_time != null)
            return false;
        if (book_ahead_time != null ? !book_ahead_time.equals(shop.book_ahead_time) : shop.book_ahead_time != null)
            return false;
        if (invoice_support != null ? !invoice_support.equals(shop.invoice_support) : shop.invoice_support != null)
            return false;
        if (min_order_price != null ? !min_order_price.equals(shop.min_order_price) : shop.min_order_price != null)
            return false;
        if (package_box_price != null ? !package_box_price.equals(shop.package_box_price) : shop.package_box_price != null)
            return false;
        if (threshold != null ? !threshold.equals(shop.threshold) : shop.threshold != null) return false;
        return shopCode != null ? shopCode.equals(shop.shopCode) : shop.shopCode == null;

    }

    @Override
    public int hashCode() {
        int result = shop_id != null ? shop_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shop_logo != null ? shop_logo.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (categorys != null ? categorys.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (service_phone != null ? service_phone.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (coord_type != null ? coord_type.hashCode() : 0);
        result = 31 * result + (delivery_region != null ? delivery_region.hashCode() : 0);
        result = 31 * result + (business_time != null ? business_time.hashCode() : 0);
        result = 31 * result + (book_ahead_time != null ? book_ahead_time.hashCode() : 0);
        result = 31 * result + (invoice_support != null ? invoice_support.hashCode() : 0);
        result = 31 * result + (min_order_price != null ? min_order_price.hashCode() : 0);
        result = 31 * result + (package_box_price != null ? package_box_price.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        result = 31 * result + (shopCode != null ? shopCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id='" + shop_id + '\'' +
                ", name='" + name + '\'' +
                ", shop_logo='" + shop_logo + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address='" + address + '\'' +
                ", brand='" + brand + '\'' +
                ", categorys=" + categorys +
                ", phone='" + phone + '\'' +
                ", service_phone='" + service_phone + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", coord_type='" + coord_type + '\'' +
                ", delivery_region=" + delivery_region +
                ", business_time=" + business_time +
                ", book_ahead_time=" + book_ahead_time +
                ", invoice_support=" + invoice_support +
                ", min_order_price=" + min_order_price +
                ", package_box_price=" + package_box_price +
                ", threshold=" + threshold +
                ", shopCode='" + shopCode + '\'' +
                '}';
    }
}
