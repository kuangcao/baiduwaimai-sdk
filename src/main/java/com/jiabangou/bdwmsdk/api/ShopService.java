package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Shop;
import com.jiabangou.bdwmsdk.model.Threshold;
import com.sun.tools.javac.util.List;

public interface ShopService extends BdWmService {

    int create(Shop shop) throws BdWmErrorException;

    boolean update(Shop shop) throws BdWmErrorException;

    void offline(String shopId) throws BdWmErrorException;

    void open(String shopId) throws BdWmErrorException;

    void close(String shopId) throws BdWmErrorException;

    void setThreshold(String shopId, List<Threshold> thresholds) throws BdWmErrorException;

    void setDeliverDelayTime(String shopId, int deliveryDelayTime) throws BdWmErrorException;
}
