package com.jiabangou.bdwmsdk.api;

public interface BdWmClient {


    void setBaiduWaimaiConfigStorage(BdWmConfigStorage baiduWaimaiConfigStorage);

    /**
     * 获取门店服务
     * @return
     */
    ShopService getShopService();

    /**
     * 获取菜品服务
     * @return
     */
    DishService getDishService();

    /**
     * 获取订单服务
     * @return
     */
    OrderService getOrderService();

}
