package com.jiabangou.bdwmsdk.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    private static final Map<Integer, String> errorMessages                    = new HashMap<Integer, String>();

    static {

        errorMessages.put(1, "error");
        errorMessages.put(20253, "商户不存在");
        errorMessages.put(20108, "命令不支持");
        errorMessages.put(20109, "来源不支持");
        errorMessages.put(20110, "签名格式不正确");
        errorMessages.put(20113, "ticket格式不正确");
        errorMessages.put(20114, "签名不匹配");
        errorMessages.put(10213, "菜品分类已存在");

    }

    public static String getMsg(int code) {
        return errorMessages.get(code);
    }
}
