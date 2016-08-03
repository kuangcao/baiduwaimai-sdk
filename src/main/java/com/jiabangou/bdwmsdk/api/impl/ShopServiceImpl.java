package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.bdwmsdk.api.ShopService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import com.jiabangou.bdwmsdk.utils.CmdUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return execute(COMMAND_SHOP_CREATE, shop).getJSONObject(CmdUtils.DATA).getIntValue("baidu_shop_id");
    }

    @Override
    public boolean update(Shop shop) throws BdWmErrorException {
        return execute(COMMAND_SHOP_UPDATE, shop).getBoolean(CmdUtils.DATA);
    }

    @Override
    public void offline(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1) {{
            put("shop_id", shopId);
        }};
        execute(COMMAND_SHOP_OFFLINE, bodyMap);
    }

    @Override
    public void open(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1) {{
            put("shop_id", shopId);
        }};
        execute(COMMAND_SHOP_OPEN, bodyMap);
    }

    @Override
    public void close(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1) {{
            put("shop_id", shopId);
        }};
        execute(COMMAND_SHOP_CLOSE, bodyMap);
    }

    @Override
    public void setThreshold(String shopId, List<Threshold> thresholds) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("shop_id", shopId);
        bodyMap.put("threshold", thresholds);
        execute(COMMAND_THRESHOLD_SET, bodyMap);
    }

    @Override
    public void setDeliverDelayTime(String shopId, int deliveryDelayTime) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("delivery_delay_time", deliveryDelayTime);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_DELIVERY_DELAY, bodyMap);
    }

    @Override
    public boolean uploadIdentityPicture(String shopId, List<Picture> pictures) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("pic", pictures);
        bodyMap.put("shop_id", shopId);
        return execute(COMMAND_UPLOAD_PIC, bodyMap).getBoolean(CmdUtils.DATA);
    }

    @Override
    public ShopDetail getDetail(String shopId) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("shop_id", shopId);
        try {
            return execute(COMMAND_SHOP_GET, bodyMap).getObject(CmdUtils.DATA, ShopDetail.class);
        } catch (BdWmErrorException e) {
            if (BdWmErrorException.SHOP_NOT_EXIST == e.getCode()) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public List<ShopDetailLite> gets() throws BdWmErrorException {
        return execute(COMMAND_SHOP_LIST, "").getJSONArray(CmdUtils.DATA)
                .stream().map(o -> TypeUtils.castToJavaBean(o, ShopDetailLite.class))
                .collect(Collectors.toList());
    }

    @Override
    public void setAnnouncement(String shopId, String content) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<>(1);
        bodyMap.put("content", content);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_SHOP_ANNOUNCEMENT_SET, bodyMap);
    }

}
