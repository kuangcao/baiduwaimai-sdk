package com.jiabangou.baiduwaimaisdk.api;

public interface BaiDuWaiMaiConfigStorage {

    int getSource();

    String getSecret();

    int getVersion();

    String getUrl();

    String getHttp_proxy_host();

    int getHttp_proxy_port();

    String getHttp_proxy_username();

    String getHttp_proxy_password();


}
