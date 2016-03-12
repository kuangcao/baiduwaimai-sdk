package com.jiabangou.bdwmsdk.api.impl;

import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.ShopService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.model.Picture;
import com.jiabangou.bdwmsdk.model.Shop;
import com.jiabangou.bdwmsdk.model.Threshold;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl extends BdWmBaseService implements ShopService {

    //商户
    //创建商户
    public final static String COMMAND_SHOP_CREATE = "shop.create";

    //修改商户
    public final static String COMMAND_SHOP_UPDATE = "shop.update";

    //下线商户
    public final static String COMMAND_SHOP_OFFLINE = "shop.offline";

    //商户开业
    public final static String COMMAND_SHOP_OPEN = "shop.open";

    //商户歇业
    public final static String COMMAND_SHOP_CLOSE = "shop.close";

    //商户订单阈值设置
    public final static String COMMAND_THRESHOLD_SET = "shop.threshold.set";

    //商户配送时延设置
    public final static String COMMAND_DELIVERY_DELAY = "shop.delivery.delay";

    //上传资质图片
    public final static String COMMAND_UPLOAD_PIC = "shop.pic.upload";

    @Override
    public int create(Shop shop) throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_SHOP_CREATE, shop);
        return doPost(cmd).getIntValue(DATA);
    }

    @Override
    public boolean update(Shop shop) throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_SHOP_UPDATE, shop);
        return doPost(cmd).getBoolean(DATA);
    }

    @Override
    public void offline(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_SHOP_OFFLINE, bodyMap);
        doPost(cmd);
    }

    @Override
    public void open(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_SHOP_OPEN, bodyMap);
        doPost(cmd);
    }

    @Override
    public void close(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_SHOP_CLOSE, bodyMap);
        doPost(cmd);
    }

    @Override
    public void setThreshold(String shopId, List<Threshold> thresholds) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("shop_id", shopId);
        bodyMap.put("threshold", thresholds);
        Cmd cmd = createCmd(COMMAND_THRESHOLD_SET, bodyMap);
        doPost(cmd);
    }

    @Override
    public void setDeliverDelayTime(String shopId, int deliveryDelayTime) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("delivery_delay_time", deliveryDelayTime);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_DELIVERY_DELAY, bodyMap);
        doPost(cmd);
    }

    @Override
    public boolean uploadIdentityPicture(String shopId, List<Picture> pictures) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("pic", pictures);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_UPLOAD_PIC, bodyMap);
        return doPost(cmd).getBoolean(DATA);
    }

}
