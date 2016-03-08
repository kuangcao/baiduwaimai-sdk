package com.jiabangou.bdwmsdk.api.impl;

import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl extends BdWmBaseService implements OrderService {

    /*上行接口*/
    public static final String ORDER_CONFIRM = "order.confirm";
    public static final String ORDER_CANCEL = "order.cancel";
    public static final String ORDER_COMPLETE = "order.complete";
    public static final String ORDER_STATUS_GET = "order.status.get";
    public static final String ORDER_GET = "order.get";
    public static final String ORDER_LIST = "order.list";

    /*下行接口*/
    public static final String ORDER_CREATE = "order.create";
    public static final String ORDER_STATUS_PUSH = "order.status.push";

    @Override
    public void confirm(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_CONFIRM, bodyMap);
        doPost(cmd);
    }

    @Override
    public void cancel(String orderId, int type, String reason) throws BdWmErrorException {
        Map<String, Object> bodyMap = new HashMap<String, Object>(1);
        bodyMap.put("order_id", orderId);
        bodyMap.put("type", type);
        bodyMap.put("reason", reason);
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
        return doPost(cmd).getObject(DATA, OrderDetail.class);
    }

    @Override
    public Page<OrderLite> getOrderLites(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("order_id", orderId);
        Cmd cmd = createCmd(ORDER_LIST, bodyMap);
        return (Page<OrderLite>)doPost(cmd).getObject(DATA, PageOrderLite.class);
    }

    @Override
    public long create(OrderDetail order) throws BdWmErrorException {
        Cmd cmd = createCmd(ORDER_CREATE, order);
        long source_order_id = doPost(cmd).getJSONObject(DATA).getLongValue("source_order_id");
        return source_order_id;
    }

    @Override
    public void pushStatus(String orderId, OrderStatus status) throws BdWmErrorException {
        Map<String, Object> bodyMap = new HashMap<String, Object>(1);
        bodyMap.put("order_id", orderId);
        bodyMap.put("status", status);
        Cmd cmd = createCmd(ORDER_STATUS_PUSH, bodyMap);
        doPost(cmd);
    }

}
