package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class OrderLite implements Serializable {

    private String order_id;
    private String status;
    private int create_time;
    private int order_status;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLite orderLite = (OrderLite) o;

        if (create_time != orderLite.create_time) return false;
        if (order_status != orderLite.order_status) return false;
        if (order_id != null ? !order_id.equals(orderLite.order_id) : orderLite.order_id != null) return false;
        return status != null ? status.equals(orderLite.status) : orderLite.status == null;

    }

    @Override
    public int hashCode() {
        int result = order_id != null ? order_id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + create_time;
        result = 31 * result + order_status;
        return result;
    }

    @Override
    public String toString() {
        return "OrderLite{" +
                "order_id='" + order_id + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                ", order_status=" + order_status +
                '}';
    }
}
