package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

import java.util.*;

public class OrderServiceImpl extends BdWmBaseService implements OrderService {

    /*上行接口*/
    public static final String ORDER_CONFIRM = "order.confirm";
    public static final String ORDER_CANCEL = "order.cancel";
    public static final String ORDER_COMPLETE = "order.complete";
    public static final String ORDER_STATUS_GET = "order.status.get";
    public static final String ORDER_GET = "order.get";
    public static final String ORDER_LIST = "order.list";

    /*下行接口*/
    public static final String RESP_ORDER_CREATE = "resp.order.create";
    public static final String RESP_ORDER_STATUS_GET = "resp.order.status.get";
    public static final String RESP_ORDER_STATUS_PUSH = "resp.order.status.push";

    @Override
    public void confirm(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_CONFIRM, bodyMap);
        doPost(cmd);
    }

    @Override
    public void cancel(String orderId, int type, String reason) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("order_id", orderId);
        bodyMap.put("reason", reason);
        bodyMap.put("type", type);
        Cmd cmd = createCmd(ORDER_CANCEL, bodyMap);
        doPost(cmd);
    }

    @Override
    public void complete(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_COMPLETE, bodyMap);
        doPost(cmd);
    }

    @Override
    public int getStatus(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_STATUS_GET, bodyMap);
        return doPost(cmd).getJSONObject(DATA).getIntValue("status");
    }

    @Override
    public OrderDetail getOrderDetail(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_GET, bodyMap);
        return getOrderDetailReq(JSON.toJSONString(doPost(cmd)));
    }

    @Override
    public Page<OrderLite> getOrderLites(long startTime, long endTime) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("end_time", endTime);
        bodyMap.put("start_time", startTime);
        Cmd cmd = createCmd(ORDER_LIST, bodyMap);
        return (Page<OrderLite>) doPost(cmd).getObject(DATA, PageOrderLite.class);
    }

    /**
     * 百度外卖下行接口相关api
     * */
    @Override
    //百度外卖创建订单时的请求数据构建对象
    public OrderDetail getOrderDetailReq(String json) {
        JSONObject jsonObject = JSON.parseObject(json).getJSONObject(BODY);
        if (jsonObject == null ){
            jsonObject = JSON.parseObject(json).getJSONObject(DATA);
        }
        //构建商户基本信息类
        ShopLite shop = jsonObject.getObject("shop", ShopLite.class);
        //构建订单基本信息类
        Order order = jsonObject.getObject("order", Order.class);
        //构建用户信息类
        User user = jsonObject.getObject("user", User.class);
        Coord coord = jsonObject.getJSONObject("user").getObject("coord", Coord.class);
        user.setCoord(coord);
        //构建订单商品类
        JSONArray productObjects = jsonObject.getJSONArray("products");
        List<Product> products = new ArrayList<Product>();
        for (Object object : productObjects) {
            Product product = JSON.parseObject(JSON.toJSONString(object), Product.class);
            products.add(product);
        }
        //构建订单活动类
        JSONArray discountObjects = jsonObject.getJSONArray("discount");
        List<Discount> discounts = new ArrayList<Discount>();
        for (Object object : discountObjects) {
            Discount product = JSON.parseObject(JSON.toJSONString(object), Discount.class);
            discounts.add(product);
        }
        //构建订单详情类
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setShopLite(shop);
        orderDetail.setOrder(order);
        orderDetail.setUser(user);
        orderDetail.setProducts(products);
        orderDetail.setDiscount(discounts);
        return orderDetail;
    }

    @Override
    //获取百度外卖创建订单的响应json字符串
    public Cmd getOrderCreateResp(String sourceOrderId) {
        Map<String, String> data = new LinkedHashMap<String, String>();
        data.put("source_order_id", sourceOrderId);
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("data", data);
        body.put("errno", 0);
        body.put("error", "success");
        return createCmd(RESP_ORDER_CREATE, body);
    }

    @Override
    //获取百度外卖执行获取订单状态操作的参数：order_id
    public String getOrderStatusGetReq(String json){
        JSONObject jsonObject = JSON.parseObject(json).getJSONObject(BODY);
        return jsonObject.getString("order_id");
    }

    @Override
    //获取百度外卖get订单状态的响应json字符串
    public Cmd getOrderStatusGetResp(String sourceOrderId, int status) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("source_order_id", sourceOrderId);
        data.put("status", status);
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("data", data);
        body.put("errno", 0);
        body.put("error", "success");
        return createCmd(RESP_ORDER_STATUS_GET, body);
    }

    @Override
    //获取百度外卖执行订单状态推送操作的参数：order_id， status
    public Map<String, Object> getOrderStatusPushReq(String json){
        JSONObject jsonObject = JSON.parseObject(json).getJSONObject(BODY);
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("order_id", jsonObject.getString("order_id"));
        bodyMap.put("status", jsonObject.getString("status"));
        return bodyMap;
    }

    @Override
    //获取百度外卖订单状态推送的响应json字符串
    public Cmd getOrderStatusPushResp() {
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("errno", 0);
        body.put("error", "success");
        return createCmd(RESP_ORDER_STATUS_PUSH, body);
    }

    @Override
    //获取百度外卖发情求出错是的响应json字符串
    public Cmd getErrorResp(String command, BdWmError error) {
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("errno", error.getErrorCode());
        body.put("error", error.getErrorMsg());
        return createCmd(command, body);
    }

}
