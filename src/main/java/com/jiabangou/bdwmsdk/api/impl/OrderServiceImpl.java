package com.jiabangou.bdwmsdk.api.impl;

import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl extends BdWmBaseService implements OrderService {

    public static final String ORDER_CONFIRM = "order.confirm";
    public static final String ORDER_CANCEL = "order.cancel";
    public static final String ORDER_COMPLETE = "order.complete";
    public static final String ORDER_STATUS_GET = "order.status.get";

    public static final String ORDER_GET = "order.get";
    public static final String ORDER_LIST = "order.list";

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
}
