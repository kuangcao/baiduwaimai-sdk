package com.jiabangou.bdwmsdk.api.impl;

import com.jiabangou.bdwmsdk.api.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class BdWmClientImpl implements BdWmClient {

    private BdWmConfigStorage baiduWaimaiConfigStorage;

    private CloseableHttpClient httpClient;

    private HttpHost httpProxy;

    private DishService dishService;
    private ShopService shopService;
    private OrderService orderService;

    public void setBaiduWaimaiConfigStorage(BdWmConfigStorage baiduWaimaiConfigStorage) {
        this.baiduWaimaiConfigStorage = baiduWaimaiConfigStorage;

        String http_proxy_host = baiduWaimaiConfigStorage.getHttp_proxy_host();
        int http_proxy_port = baiduWaimaiConfigStorage.getHttp_proxy_port();
        String http_proxy_username = baiduWaimaiConfigStorage.getHttp_proxy_username();
        String http_proxy_password = baiduWaimaiConfigStorage.getHttp_proxy_password();

        final HttpClientBuilder builder = HttpClients.custom();
        if (StringUtils.isNotBlank(http_proxy_host)) {
            // 使用代理服务器
            if (StringUtils.isNotBlank(http_proxy_username)) {
                // 需要用户认证的代理服务器
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                        new AuthScope(http_proxy_host, http_proxy_port),
                        new UsernamePasswordCredentials(http_proxy_username, http_proxy_password));
                builder
                        .setDefaultCredentialsProvider(credsProvider);
            }
            httpProxy = new HttpHost(http_proxy_host, http_proxy_port);
        }
        httpClient = builder.build();
    }

    public DishService getDishService() {
        if (dishService == null) {
            DishService service = new DishServiceImpl();
            service.setHttpClient(httpClient);
            service.setHttpHost(httpProxy);
            service.setBdWmConfigStorage(baiduWaimaiConfigStorage);
            dishService = service;
            return dishService;
        } else {
            return dishService;
        }
    }


    public ShopService getShopService() {
        if (shopService == null) {
            ShopService service = new ShopServiceImpl();
            service.setHttpClient(httpClient);
            service.setHttpHost(httpProxy);
            service.setBdWmConfigStorage(baiduWaimaiConfigStorage);
            shopService = service;
            return shopService;
        } else {
            return shopService;
        }
    }

    public OrderService getOrderService() {
        if (orderService == null) {
            OrderService service = new OrderServiceImpl();
            service.setHttpClient(httpClient);
            service.setHttpHost(httpProxy);
            service.setBdWmConfigStorage(baiduWaimaiConfigStorage);
            orderService = service;
            return orderService;
        } else {
            return orderService;
        }
    }

}
