package com.jiabangou.baiduwaimaisdk.exception;

/**
 * 达达快递错误码说明
 * https://open.imdada.cn/wiki/errorCode/
 */
public class BaiduWaiMaiErrorException extends Exception {

    protected int code;

    public BaiduWaiMaiErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaiduWaiMaiErrorException(int code) {
        super(ErrorCode.getMsg(code));
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "BaiduWaiMaiErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                "} " + super.toString();
    }

}
