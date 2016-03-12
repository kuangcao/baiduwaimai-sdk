package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

import java.util.Map;

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
     * @param orderId 订单id
     * @param type 订单取消原因分类
     * @param reason 订单取消原因描述
     */
    void cancel(String orderId, int type, String reason) throws BdWmErrorException;

    /**
     * <pre>
     * 完成订单
     * 提供给合作方反馈订单状态为完成所用。确认订单后才能完成订单。 注：1、非完成态的订单不予结算。2、百度配送订单由骑士完成。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_complete
     * </pre>
     * @param orderId 订单id
     * @throws BdWmErrorException
     */
    void complete(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * 查看订单状态
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_status_get
     * </pre>
     * @param orderId 订单id
     * @return 订单状态码
     * @throws BdWmErrorException
     */
    int getStatus(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * 查看订单详情
     * 提供给合作方查看订单详情所用。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_get
     * </pre>
     * @param orderId 订单id
     * @return 订单详情
     * @throws BdWmErrorException
     */
    OrderDetail getOrderDetail(String orderId) throws BdWmErrorException;

    /**
     * <pre>
     * 查看订单列表
     * 提供给合作方查看订单列表所用。
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_list
     * </pre>
     * @param startTime 开始时间(时间是10的时间戳)
     * @param endTime 结束时间(时间是10的时间戳)
     * @return 订单列表
     * @throws BdWmErrorException
     */
    Page<OrderLite> getOrderLites(long startTime, long endTime) throws BdWmErrorException;

    /**
     * <pre>
     * 订单下行接口，获取创建订单请求数据的对象
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_thr_order_create
     * </pre>
     * @param json 请求的json数据
     * @return 订单详情对象
     */
    OrderDetail getOrderDetailReq(String json);

    /**
     * <pre>
     * 订单下行接口，获取创建订单响应数据
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_thr_order_create
     * </pre>
     * @param sourceOrderId 合作方订单id
     * @return 订单创建的响应json数据
     */
    Cmd getOrderCreateResp(String sourceOrderId);

    /**
     * <pre>
     * 订单下行接口，获取百度外卖执行“获取合作方订单状态”操作的参数
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_thr_order_status_get
     * </pre>
     * @param json 请求的json数据
     * @return order_id
     */
    String getOrderStatusGetReq(String json);

    /**
     * <pre>
     * 订单下行接口，获取百度外卖执行“获取合作方订单状态”操作的响应json数据
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_thr_order_status_get
     * </pre>
     * @param sourceOrderId 合作方订单id
     * @param status 订单状态
     * @return 响应json数据
     */
    Cmd getOrderStatusGetResp(String sourceOrderId, int status);

    /**
     * <pre>
     * 订单下行接口，获取百度外卖执行“推送订单状态”操作的请求参数
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_status_push
     * </pre>
     * @param json 请求的json数据
     * @return 请求的参数（order_id， status）
     */
    Map<String, Object> getOrderStatusPushReq(String json);

    /**
     * <pre>
     * 订单下行接口，获取百度外卖执行“推送订单状态”操作的响应数据
     * 参考: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_order_status_push
     * </pre>
     * @return 响应json数据
     */
    Cmd getOrderStatusPushResp();


    /**
     * <pre>
     * 订单下行接口，获取百度外卖出错响应数据
     * </pre>
     * @param command 出错的操作命令
     * @param error 百度外卖error对象
     * @return 响应json数据
     */
    Cmd getErrorResp(String command, BdWmError error);

}
