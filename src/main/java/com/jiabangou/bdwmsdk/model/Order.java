package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
@JSONType
public class Order implements Serializable {

    private String order_id;
    private int send_immediately;
    private String send_time;
    private int send_fee;
    private int package_fee;
    private int discount_fee;
    private int total_fee;
    private int shop_fee;
    private int user_fee;
    private int pay_type;
    private int pay_status;
    private int need_invoice;
    private String invoice_title;
    private String remark;
    private int delivery_party;
    private String create_time;
    private String cancel_time;
    private String pickup_time;
    private String atshop_time;
    private String delivery_time;
    private String delivery_phone;
    private String finished_time;
    private String confirm_time;

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getAtshop_time() {
        return atshop_time;
    }

    public void setAtshop_time(String atshop_time) {
        this.atshop_time = atshop_time;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getDelivery_phone() {
        return delivery_phone;
    }

    public void setDelivery_phone(String delivery_phone) {
        this.delivery_phone = delivery_phone;
    }

    public String getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(String finished_time) {
        this.finished_time = finished_time;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getSend_immediately() {
        return send_immediately;
    }

    public void setSend_immediately(int send_immediately) {
        this.send_immediately = send_immediately;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public int getSend_fee() {
        return send_fee;
    }

    public void setSend_fee(int send_fee) {
        this.send_fee = send_fee;
    }

    public int getPackage_fee() {
        return package_fee;
    }

    public void setPackage_fee(int package_fee) {
        this.package_fee = package_fee;
    }

    public int getDiscount_fee() {
        return discount_fee;
    }

    public void setDiscount_fee(int discount_fee) {
        this.discount_fee = discount_fee;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getShop_fee() {
        return shop_fee;
    }

    public void setShop_fee(int shop_fee) {
        this.shop_fee = shop_fee;
    }

    public int getUser_fee() {
        return user_fee;
    }

    public void setUser_fee(int user_fee) {
        this.user_fee = user_fee;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getNeed_invoice() {
        return need_invoice;
    }

    public void setNeed_invoice(int need_invoice) {
        this.need_invoice = need_invoice;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDelivery_party() {
        return delivery_party;
    }

    public void setDelivery_party(int delivery_party) {
        this.delivery_party = delivery_party;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(String cancel_time) {
        this.cancel_time = cancel_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (send_immediately != order.send_immediately) return false;
        if (send_fee != order.send_fee) return false;
        if (package_fee != order.package_fee) return false;
        if (discount_fee != order.discount_fee) return false;
        if (total_fee != order.total_fee) return false;
        if (shop_fee != order.shop_fee) return false;
        if (user_fee != order.user_fee) return false;
        if (pay_type != order.pay_type) return false;
        if (pay_status != order.pay_status) return false;
        if (need_invoice != order.need_invoice) return false;
        if (delivery_party != order.delivery_party) return false;
        if (order_id != null ? !order_id.equals(order.order_id) : order.order_id != null) return false;
        if (send_time != null ? !send_time.equals(order.send_time) : order.send_time != null) return false;
        if (invoice_title != null ? !invoice_title.equals(order.invoice_title) : order.invoice_title != null)
            return false;
        if (remark != null ? !remark.equals(order.remark) : order.remark != null) return false;
        if (create_time != null ? !create_time.equals(order.create_time) : order.create_time != null) return false;
        if (cancel_time != null ? !cancel_time.equals(order.cancel_time) : order.cancel_time != null) return false;
        if (pickup_time != null ? !pickup_time.equals(order.pickup_time) : order.pickup_time != null) return false;
        if (atshop_time != null ? !atshop_time.equals(order.atshop_time) : order.atshop_time != null) return false;
        if (delivery_time != null ? !delivery_time.equals(order.delivery_time) : order.delivery_time != null)
            return false;
        if (delivery_phone != null ? !delivery_phone.equals(order.delivery_phone) : order.delivery_phone != null)
            return false;
        if (finished_time != null ? !finished_time.equals(order.finished_time) : order.finished_time != null)
            return false;
        return confirm_time != null ? confirm_time.equals(order.confirm_time) : order.confirm_time == null;

    }

    @Override
    public int hashCode() {
        int result = order_id != null ? order_id.hashCode() : 0;
        result = 31 * result + send_immediately;
        result = 31 * result + (send_time != null ? send_time.hashCode() : 0);
        result = 31 * result + send_fee;
        result = 31 * result + package_fee;
        result = 31 * result + discount_fee;
        result = 31 * result + total_fee;
        result = 31 * result + shop_fee;
        result = 31 * result + user_fee;
        result = 31 * result + pay_type;
        result = 31 * result + pay_status;
        result = 31 * result + need_invoice;
        result = 31 * result + (invoice_title != null ? invoice_title.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + delivery_party;
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (cancel_time != null ? cancel_time.hashCode() : 0);
        result = 31 * result + (pickup_time != null ? pickup_time.hashCode() : 0);
        result = 31 * result + (atshop_time != null ? atshop_time.hashCode() : 0);
        result = 31 * result + (delivery_time != null ? delivery_time.hashCode() : 0);
        result = 31 * result + (delivery_phone != null ? delivery_phone.hashCode() : 0);
        result = 31 * result + (finished_time != null ? finished_time.hashCode() : 0);
        result = 31 * result + (confirm_time != null ? confirm_time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", send_immediately=" + send_immediately +
                ", send_time='" + send_time + '\'' +
                ", send_fee=" + send_fee +
                ", package_fee=" + package_fee +
                ", discount_fee=" + discount_fee +
                ", total_fee=" + total_fee +
                ", shop_fee=" + shop_fee +
                ", user_fee=" + user_fee +
                ", pay_type=" + pay_type +
                ", pay_status=" + pay_status +
                ", need_invoice=" + need_invoice +
                ", invoice_title='" + invoice_title + '\'' +
                ", remark='" + remark + '\'' +
                ", delivery_party=" + delivery_party +
                ", create_time='" + create_time + '\'' +
                ", cancel_time='" + cancel_time + '\'' +
                ", pickup_time='" + pickup_time + '\'' +
                ", atshop_time='" + atshop_time + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                ", delivery_phone='" + delivery_phone + '\'' +
                ", finished_time='" + finished_time + '\'' +
                ", confirm_time='" + confirm_time + '\'' +
                '}';
    }
}
