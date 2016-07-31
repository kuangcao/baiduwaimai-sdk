package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.bdwmsdk.api.*;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import com.jiabangou.bdwmsdk.model.OrderStatusResult;
import com.jiabangou.bdwmsdk.utils.CmdUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BdWmClientImpl implements BdWmClient {

    private BdWmConfigStorage baiduWaimaiConfigStorage;
    private LogListener logListener;

    private CloseableHttpClient httpClient;

    private HttpHost httpProxy;

    private DishService dishService;
    private ShopService shopService;
    private OrderService orderService;
    private PushConsumer pushConsumer;

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

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public void setPushConsumer(PushConsumer pushConsumer) {
        this.pushConsumer = pushConsumer;
    }

    @Override
    public Cmd pushHandle(String requestJsonString) {
        try {
            Cmd requestCmd = CmdUtils.parseCmd(requestJsonString,
                    baiduWaimaiConfigStorage.getSource(),
                    baiduWaimaiConfigStorage.getSecret());
            if (this.pushConsumer == null) {
                throw new BdWmErrorException(1, "pushConsumer does not implement");
            }
            if (PushConsumer.CMD_ORDER_CREATE.equals(requestCmd.getCmd())) {
                String sourceOrderId = pushConsumer.createOrder(TypeUtils.castToJavaBean(requestCmd.getBody(), OrderDetail.class));
                Map<String, String> data = new HashMap<String, String>() {{
                    put("source_order_id", sourceOrderId);
                }};

                return CmdUtils.buildSuccessCmd(
                        baiduWaimaiConfigStorage.getSource(),
                        baiduWaimaiConfigStorage.getSecret(),
                        CmdUtils.VERSION,
                        CmdUtils.getResponseCmdName(requestCmd.getCmd()),
                        data);
            } else if (PushConsumer.CMD_ORDER_STATUS_GET.equals(requestCmd.getCmd())) {
                OrderStatusResult orderStatusResult = pushConsumer
                        .getOrderStatus(((JSONObject)requestCmd.getBody()).getString("order_id"));

                return CmdUtils.buildSuccessCmd(
                        baiduWaimaiConfigStorage.getSource(),
                        baiduWaimaiConfigStorage.getSecret(),
                        CmdUtils.VERSION,
                        CmdUtils.getResponseCmdName(requestCmd.getCmd()),
                        orderStatusResult);
            } else if (PushConsumer.CMD_ORDER_STATUS_PUSH.equals(requestCmd.getCmd())) {
                JSONObject jsonObject = (JSONObject)requestCmd.getBody();
                String orderId = jsonObject.getString("order_id");
                int status = jsonObject.getIntValue("status");
                pushConsumer.pushOrderStatus(orderId, status);

                return CmdUtils.buildSuccessCmd(
                        baiduWaimaiConfigStorage.getSource(),
                        baiduWaimaiConfigStorage.getSecret(),
                        CmdUtils.VERSION,
                        CmdUtils.getResponseCmdName(requestCmd.getCmd()));
            }
            throw new BdWmErrorException(1, "push cmd processer is not found.");
        } catch (BdWmErrorException e) {
            JSONObject jsonObject = JSONObject.parseObject(requestJsonString);
            return CmdUtils.buildErrorCmd(baiduWaimaiConfigStorage.getSource(),
                    baiduWaimaiConfigStorage.getSecret(), CmdUtils.VERSION,
                    CmdUtils.getResponseCmdName(jsonObject.getString("cmd")),
                    e);
        }
    }

    public DishService getDishService() {
        if (dishService == null) {
            DishService service = new DishServiceImpl();
            service.setHttpClient(httpClient);
            service.setHttpHost(httpProxy);
            service.setBdWmConfigStorage(baiduWaimaiConfigStorage);
            service.setLogListener(logListener);
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
            service.setLogListener(logListener);
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
            service.setLogListener(logListener);
            orderService = service;
            return orderService;
        } else {
            return orderService;
        }
    }

}
