package com.jiabangou.bdwmsdk.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    private static final Map<Integer, String> errorMessages                    = new HashMap<Integer, String>();

    static {

        errorMessages.put(1, "error");
        /*系统*/
        errorMessages.put(20100, "请求方法不支持");
        errorMessages.put(20101, "请求格式不正确");
        errorMessages.put(20201, "没有权限");
        errorMessages.put(20207, "账号未上线");
        errorMessages.put(10208, "参数不合法");
        errorMessages.put(10209, "配送范围不合法");
        errorMessages.put(10222, "餐盒费不一致");
        errorMessages.put(20108, "命令不支持");
        errorMessages.put(20109, "来源不支持");
        errorMessages.put(20110, "签名格式不正确");
        errorMessages.put(20113, "ticket格式不正确");
        errorMessages.put(20114, "签名不匹配");
        errorMessages.put(20200, "参数错误");
        /*商户*/
        errorMessages.put(20252, "商户已存在");
        errorMessages.put(20240, "供应商未上线");
        errorMessages.put(20291, "测试商户数已达上限");
        errorMessages.put(20290, "城市不支持");
        /*菜品*/
        errorMessages.put(20253, "商户不存在");
        errorMessages.put(10213, "菜品分类已存在");
        errorMessages.put(10213, "菜品分类不存在");
        errorMessages.put(10205, "未知菜品分类");
        errorMessages.put(10203, "菜品重复");
        errorMessages.put(20270, "菜品不存在");
        /*上行订单*/
        errorMessages.put(20212, "订单不存在");
        errorMessages.put(20216, "订单已取消");
        errorMessages.put(20217, "订单已完成");

    }

    public static String getMsg(int code) {
        return errorMessages.get(code);
    }
}
