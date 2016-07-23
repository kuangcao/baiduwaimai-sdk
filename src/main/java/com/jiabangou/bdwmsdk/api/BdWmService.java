package com.jiabangou.bdwmsdk.api;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

public interface BdWmService {

    void setBdWmConfigStorage(BdWmConfigStorage bdWmConfigStorage);

    void setLogListener(LogListener logListener);

    void setHttpClient(CloseableHttpClient httpClient);

    void setHttpHost(HttpHost httpProxy);

}
