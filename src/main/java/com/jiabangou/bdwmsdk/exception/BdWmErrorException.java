package com.jiabangou.bdwmsdk.exception;

import com.jiabangou.bdwmsdk.model.BdWmError;

/**
 * 达达快递错误码说明
 * https://open.imdada.cn/wiki/errorCode/
 */
public class BdWmErrorException extends Exception {

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
