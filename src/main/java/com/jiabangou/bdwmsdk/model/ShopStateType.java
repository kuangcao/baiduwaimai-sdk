package com.jiabangou.bdwmsdk.model;

/**
 * Created by wanglei on 16-11-4.
 */
public enum ShopStateType {
    OPEN(1, "营业中"),
    CLOSED(3, "暂停营业"),
    OFFLINE(9, "下线"),
    ;

    // 成员变量
    private String name;
    private int type;

    // 构造方法
    ShopStateType(int type, String name) {
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
