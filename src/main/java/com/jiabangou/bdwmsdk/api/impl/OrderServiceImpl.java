package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Cmd;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl extends BdWmBaseService implements OrderService {

    public static final String ORDER_CONFIRM = "order.confirm";
    public static final String ORDER_CANCEL = "order.cancel";
    public static final String ORDER_COMPLETE = "order.complete";
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

}
