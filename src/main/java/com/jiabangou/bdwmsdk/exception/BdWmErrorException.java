package com.jiabangou.bdwmsdk.exception;

import com.jiabangou.bdwmsdk.model.BdWmError;

/**
 * 达达快递错误码说明
 * https://open.imdada.cn/wiki/errorCode/
 */
public class BdWmErrorException extends Exception {

    /**
     * 商店已存在
     */
    public static final int SHOP_ALREADY_EXIST = 20252;
    /**
     * 商店不存在
     */
    public static final int SHOP_NOT_EXIST = 20253;
    /**
     * 未知菜品分类错误
     */
    public static final int UNKNOW_CATEGORY_ERROR = 10205;
    /**
     * 分类已存在
     */
    public static final int CATEGORY_ALREADY_EXISTS = 10213;
    /**
     * 菜品已存在
     */
    public static final int DISH_ALREADY_EXIST = 10203;

    protected int code;

    public BdWmErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BdWmErrorException(BdWmError error) {
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "BdWmErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                "} " + super.toString();
    }

}
