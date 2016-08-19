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
        //prod
//        baiduWaimaiConfigStorage.setSource("30137");
//        baiduWaimaiConfigStorage.setSecret("66a2b33605692114");
        //test
        baiduWaimaiConfigStorage.setSource("65400");
        baiduWaimaiConfigStorage.setSecret("2540f3c01ae977d8");
        bdWmClient.setBaiduWaimaiConfigStorage(baiduWaimaiConfigStorage);
        bdWmClient.setLogListener((cmd, isSuccess, request, response) -> {
            System.out.println("cmd:"+cmd);
            System.out.println("isSuccess:"+isSuccess);
            System.out.println("request:"+ JSON.toJSONString(JSON.parseObject(request), SerializerFeature.PrettyFormat, SerializerFeature.SortField));
            System.out.println("response:"+JSON.toJSONString(JSON.parseObject(response), SerializerFeature.PrettyFormat, SerializerFeature.SortField));
        });
        return bdWmClient;
    }

}
