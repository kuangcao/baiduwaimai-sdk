package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.ShopService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

import java.util.*;

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

    //获取商户信息
    public final static String COMMAND_SHOP_GET = "shop.get";

    //获取商户列表
    public final static String COMMAND_SHOP_LIST = "shop.list";

    //商户公告设置
    public final static String COMMAND_SHOP_ANNOUNCEMENT_SET = "shop.announcement.set";

    @Override
    public int create(Shop shop) throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_SHOP_CREATE, shop);
        return doPost(cmd).getJSONObject(DATA).getIntValue("baidu_shop_id");
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

    @Override
    public ShopDetail getDetail(String shopId) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_SHOP_GET, bodyMap);
        return doPost(cmd).getObject(DATA, ShopDetail.class);
    }

    @Override
    public List<ShopDetailLite> gets() throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_SHOP_LIST, "");
        JSONArray array = doPost(cmd).getJSONArray(DATA);
        List<ShopDetailLite> shops = new ArrayList<ShopDetailLite>();
        for (Object object: array){
            shops.add(JSON.parseObject(JSON.toJSONString(object), ShopDetailLite.class));
        }
        return shops;
    }

    @Override
    public void setAnnouncement(String shopId, String content) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1);
        bodyMap.put("content", content);
        bodyMap.put("shop_id", shopId);
        Cmd cmd = createCmd(COMMAND_SHOP_ANNOUNCEMENT_SET, bodyMap);
        doPost(cmd);
    }

}
