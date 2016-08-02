package com.jiabangou.bdwmsdk.model;

import org.apache.commons.lang.StringUtils;

/**
 * 优惠类型
 * Created by freeway on 16/8/2.
 */
public enum DiscountType {

    //立减N元；满M元减N元
    JIAN("jian", "立减优惠"),
    //下单免配送费；满 N 元免配送费
    MIAN("mian", "免配送费"),
    //新用户立减 N 元
    XIN("xin", "新用户立减"),
    //订单满 M 元，赠 A x 份，如：加多宝 2 份
    ZENG("zeng", "下单满赠"),
    //订单满 M 元，使用在线支付立减 N 元
    PAY_ENJOY("payEnjoy", "在线支付营销"),
    //在指定时间内，订单满 M 元，立减 N 元
    PREORDER("preorder", "预订优惠"),
    //订单满 M 元，返 A 代金卷 x 张
    FAN("fan", "返券优惠"),
    //代金券信息
    COUPON("coupon", "代金券优惠");
    private String code;
    private String name;

    DiscountType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDiscountTypeName(String code) {
        for (DiscountType type : DiscountType.values()) {
            if (StringUtils.equals(type.getCode(), code)) {
                return type.getName();
            }
        }
        return "";
    }
}
