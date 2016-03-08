package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BdWmError implements Serializable {

    private int errorCode;

    private String errorMsg;

    private String json;

    public static BdWmError fromJson(JSONObject jsonObject) {
        JSONObject body = jsonObject.getJSONObject("body");
        if (0 != body.getIntValue("errno")) {
            BdWmError error = new BdWmError();
            error.setErrorCode(body.getIntValue("errno"));
            error.setErrorMsg(body.getString("error"));
            error.setJson(jsonObject.toJSONString());
            return error;
        }
        return null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BdWmError bdWmError = (BdWmError) o;

        if (errorCode != bdWmError.errorCode) return false;
        if (errorMsg != null ? !errorMsg.equals(bdWmError.errorMsg) : bdWmError.errorMsg != null) return false;
        return json != null ? json.equals(bdWmError.json) : bdWmError.json == null;

    }

    @Override
    public int hashCode() {
        int result = errorCode;
        result = 31 * result + (errorMsg != null ? errorMsg.hashCode() : 0);
        result = 31 * result + (json != null ? json.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BdWmError{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", json='" + json + '\'' +
                '}';
    }
}
