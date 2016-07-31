package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import com.jiabangou.bdwmsdk.model.OrderStatusResult;

/**
 * 推送处理接口, 需要业务自己实现推送后的处理
 * Created by freeway on 16/7/19.
 */
public interface PushConsumer {

    String CMD_ORDER_CREATE = "order.create";
    String CMD_ORDER_STATUS_GET = "order.status.get";
    String CMD_ORDER_STATUS_PUSH = "order.status.push";

    /**
     * 创建订单
     * <pre>
     * 参考    http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_thr_order_create
     * </pre>
     * @param order 订单
     * @return 当前我方系统的订单id
     */
    String createOrder(OrderDetail order);

    /**
     * 订单状态变更推送接收
     * <pre>
     * 参考    http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_status_push
     * </pre>
     * @param orderId 订单id
     * @return 订单状态返回结果
     */
    OrderStatusResult getOrderStatus(String orderId);

    /**
     * 订单状态推送
     * <pre>
     * 参考    http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_status_push
     * </pre>
     * @param orderId 订单id
     * @param status 状态
     */
    void pushOrderStatus(String orderId, int status);
}
