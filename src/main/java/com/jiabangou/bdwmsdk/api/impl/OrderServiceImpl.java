package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import com.jiabangou.bdwmsdk.model.OrderLite;
import com.jiabangou.bdwmsdk.model.Page;
import com.jiabangou.bdwmsdk.utils.CmdUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderServiceImpl extends BdWmBaseService implements OrderService {

    /*上行接口*/
    public static final String ORDER_CONFIRM = "order.confirm";
    public static final String ORDER_CANCEL = "order.cancel";
    public static final String ORDER_COMPLETE = "order.complete";
    public static final String ORDER_STATUS_GET = "order.status.get";
    public static final String ORDER_GET = "order.get";
    public static final String ORDER_LIST = "order.list";

    @Override
    public void confirm(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("order_id", orderId);
        execute(ORDER_CONFIRM, bodyMap);
    }

    @Override
    public void cancel(String orderId, int type, String reason) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(3);
        bodyMap.put("order_id", orderId);
        bodyMap.put("reason", reason);
        bodyMap.put("type", type);
        execute(ORDER_CANCEL, bodyMap);
    }

    @Override
    public void complete(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("order_id", orderId);
        execute(ORDER_COMPLETE, bodyMap);
    }

    @Override
    public int getStatus(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("order_id", orderId);
        return execute(ORDER_STATUS_GET, bodyMap).getIntValue("status");
    }

    @Override
    public OrderDetail getOrderDetail(String orderId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("order_id", orderId);
        return execute(ORDER_GET, bodyMap).getObject(CmdUtils.DATA, OrderDetail.class);
    }

    @Override
    public Page<OrderLite> getOrderLites(long startTime, long endTime) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("end_time", endTime);
        bodyMap.put("start_time", startTime);
        JSONObject jsonObject = execute(ORDER_LIST, bodyMap);
        return JSON.parseObject(jsonObject.getJSONObject(CmdUtils.DATA).toJSONString(),
                new TypeReference<Page<OrderLite>>() {
                });
    }

}
