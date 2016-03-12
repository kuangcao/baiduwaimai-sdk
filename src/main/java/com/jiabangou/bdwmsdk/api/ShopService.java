package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Picture;
import com.jiabangou.bdwmsdk.model.Shop;
import com.jiabangou.bdwmsdk.model.Threshold;
import java.util.List;

public interface ShopService extends BdWmService {

    /**
     * <pre>
     * 创建商户
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_create
     * </pre>
     * @param shop 商户信息
     * @throws BdWmErrorException
     */
    int create(Shop shop) throws BdWmErrorException;

    /**
     * <pre>
     * 更新商户信息
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_update
     * </pre>
     * @param shop 商户信息
     * @throws BdWmErrorException
     */
    boolean update(Shop shop) throws BdWmErrorException;

    /**
     * <pre>
     * 商户下线
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_offline
     * </pre>
     * @param shopId 商户id
     * @throws BdWmErrorException
     */
    void offline(String shopId) throws BdWmErrorException;

    /**
     * <pre>
     * 商户开业
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_open
     * </pre>
     * @param shopId 商户id
     * @throws BdWmErrorException
     */
    void open(String shopId) throws BdWmErrorException;

    /**
     * <pre>
     * 商户歇业
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_close
     * </pre>
     * @param shopId 商户id
     * @throws BdWmErrorException
     */
    void close(String shopId) throws BdWmErrorException;

    /**
     * <pre>
     * 商户订单阈值设置
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_threshold_set
     * </pre>
     * @param shopId 商户id
     * @throws BdWmErrorException
     */
    void setThreshold(String shopId, List<Threshold> thresholds) throws BdWmErrorException;

    /**
     * <pre>
     * 商户配送时延设置
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_delivery_delay
     * </pre>
     * @param shopId 商户id
     * @param deliveryDelayTime 延迟分钟数
     * @throws BdWmErrorException
     */
    void setDeliverDelayTime(String shopId, int deliveryDelayTime) throws BdWmErrorException;

    /**
     * <pre>
     * 上传商户资质图片
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_shop_pic_upload
     * </pre>
     * @param shopId 商户id
     * @param pictures 图片
     * @return
     * @throws BdWmErrorException
     */
    boolean uploadIdentityPicture(String shopId, List<Picture> pictures) throws BdWmErrorException;
}
