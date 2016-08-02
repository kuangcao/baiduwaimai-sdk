package com.jiabangou.bdwmsdk.model;

/**
 * <pre>
 *  状态码	说明
 *  1	不在配送范围内
 *  2	餐厅已打烊
 *  3	美食已售完
 *  4	菜品价格发生变化
 *  5	用户取消订单
 *  6	重复订单
 *  7	餐厅太忙
 *  8	联系不上用户
 *  9	假订单
 *  -1	自定义输入
 * </pre>
 */
public enum OrderCancelType {

    NO_SCOPE(1, "不在配送范围内"),
    CLOSED(2, "餐厅已打烊"),
    SOLD_OUT(3, "美食已售完"),
    PRICE_CHANGES(4, "菜品价格发生变化"),
    USER_CANCEL_ORDER(5, "用户取消订单"),
    REPEAT_ORDER(6, "重复订单"),
    TOO_BUSY(7, "餐厅太忙"),
    CAN_NOT_CONTACT_USER(8, "联系不上用户"),
    FALSE_ORDER(9, "假订单"),
    CUSTOM(-1, "自定义输入");

    // 成员变量
    private String name;
    private int type;

    // 构造方法
    OrderCancelType(int type, String name) {
        this.name = name;
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

}
