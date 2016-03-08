package com.jiabangou.bdwmsdk.model;

public enum OrderStatus {

    /**
     * 1	待确认
     * 5	已确认
     * 7	正在取餐	骑士取餐路上
     * 8	正在配送	骑士配送中
     * 9	已完成
     * 10	已取消
     */
    PENDING(1, "待确认"),
    CONFIRMED(5, "已确认"),
    TAKING_FOOD(7, "正在取餐"),
    BEING_DISTRIBUTION(8, "正在配送"),
    FININSHED(9, "已完成"),
    CANCEL(10, "已取消");

    // 成员变量
    private String name;
    private int status;

    OrderStatus(int status, String name) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }


    public int getStatus() {
        return status;
    }

}
