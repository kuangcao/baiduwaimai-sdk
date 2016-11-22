package com.jabangou.bdwmsdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jiabangou.bdwmsdk.api.impl.BdWmClientImpl;
import com.jiabangou.bdwmsdk.api.impl.BdWmInMemoryConfigStorage;

/**
 * Created by wanglei on 16-8-19.
 */
public class ServiceTest {

    public BdWmClientImpl getBdWmClient() {

        BdWmClientImpl bdWmClient = new BdWmClientImpl();
        BdWmInMemoryConfigStorage baiduWaimaiConfigStorage = new BdWmInMemoryConfigStorage();

        bdWmClient.setBaiduWaimaiConfigStorage(baiduWaimaiConfigStorage);
        bdWmClient.setLogListener((cmd, method, isSuccess, request, response) -> {
            System.out.println("cmd:"+cmd);
            System.out.println("method:"+method);
            System.out.println("isSuccess:"+isSuccess);
            System.out.println("request:"+ JSON.toJSONString(JSON.parseObject(request), SerializerFeature.PrettyFormat, SerializerFeature.SortField));
            System.out.println("response:"+JSON.toJSONString(JSON.parseObject(response), SerializerFeature.PrettyFormat, SerializerFeature.SortField));
        });
        return bdWmClient;
    }

}
