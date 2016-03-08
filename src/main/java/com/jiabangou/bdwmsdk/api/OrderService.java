package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import com.jiabangou.bdwmsdk.model.OrderLite;
import com.jiabangou.bdwmsdk.model.Page;

public interface OrderService extends BdWmService {

    /**
     * <pre>
     * 获取城市信息列表
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_confirm
     * </pre>
     * @param orderId 订单id
     * @throws BdWmErrorException
     */
    void confirm(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * type和String参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_appendix
     * 可以从 OrderCancelType 提取 type 和 reason
     * </pre>
     * @param orderId
     * @param type
     * @param reason
     */
    void cancel(String orderId, int type, String reason) throws BdWmErrorException;

    /**
     * <pre>
     * 完成订单
     * 提供给合作方反馈订单状态为完成所用。确认订单后才能完成订单。 注：1、非完成态的订单不予结算。2、百度配送订单由骑士完成。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_complete
     * </pre>
     * @param orderId
     * @throws BdWmErrorException
     */
    void complete(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     *
     * </pre>
     * @param orderId
     * @return
     * @throws BdWmErrorException
     */
    int getStatus(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * 查看订单详情
     * 提供给合作方查看订单详情所用。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_get
     * </pre>
     * @param orderId
     * @return
     * @throws BdWmErrorException
     */
    OrderDetail getOrderDetail(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * 查看订单列表
     * 提供给合作方查看订单列表所用。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_list
     * </pre>
     * @param orderId
     * @return
     * @throws BdWmErrorException
     */
    Page<OrderLite> getOrderLites(String orderId) throws BdWmErrorException;
}
