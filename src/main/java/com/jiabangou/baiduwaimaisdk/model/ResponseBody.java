package com.jiabangou.baiduwaimaisdk.model;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by konghang on 16/3/3.
 */
public class ResponseBody<T> {

    protected Integer errno;

    protected String error;

    protected String data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        if(errno.equals(0)){

            Type t = this.getClass().getGenericSuperclass();
            if(t instanceof ParameterizedType){
                Type[] argTypes = ((ParameterizedType)t).getActualTypeArguments();
                return JSON.parseObject(data,argTypes[0]);
            }

            return null;
        }
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
