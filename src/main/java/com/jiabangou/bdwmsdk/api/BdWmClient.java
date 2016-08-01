package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.model.Cmd;

public interface BdWmClient {


    void setBaiduWaimaiConfigStorage(BdWmConfigStorage baiduWaimaiConfigStorage);

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

    /**
     * 用于接收获取到的json字符串
     *
     * @param requestJsonString
     * @return
     */
    Cmd pushHandle(String requestJsonString);

    /**
     * 获取门店服务
     *
     * @return
     */
    ShopService getShopService();

    /**
     * 获取菜品服务
     *
     * @return
     */
    DishService getDishService();

    /**
     * 获取订单服务
     *
     * @return
     */
    OrderService getOrderService();

}
