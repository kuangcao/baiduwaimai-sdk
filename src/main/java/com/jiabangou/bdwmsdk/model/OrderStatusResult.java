package com.jiabangou.bdwmsdk.model;

public class OrderStatusResult {

    private String source_order_id;
    private int status;

    /**
     * 合作方订单 ID
     * @return
     */
    public String getSource_order_id() {
        return source_order_id;
    }

    /**
     * 合作方订单 ID
     * @param source_order_id
     */
    public void setSource_order_id(String source_order_id) {
        this.source_order_id = source_order_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatusResult{" +
                "source_order_id='" + source_order_id + '\'' +
                ", status=" + status +
                '}';
    }
}
