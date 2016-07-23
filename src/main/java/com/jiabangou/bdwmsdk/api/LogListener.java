package com.jiabangou.bdwmsdk.api;

/**
 * 日志监听器
 * Created by freeway on 16/7/23.
 */
public interface LogListener  {

    void requestEvent(String cmd, boolean isSuccess, String request, String response);

}
