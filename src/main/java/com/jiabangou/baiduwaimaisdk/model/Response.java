package com.jiabangou.baiduwaimaisdk.model;

/**
 * Created by konghang on 16/3/3.
 */
public class Response<T> extends Cmd{

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
