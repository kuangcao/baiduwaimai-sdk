package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jiabangou.bdwmsdk.api.BdWmConfigStorage;
import com.jiabangou.bdwmsdk.api.BdWmService;
import com.jiabangou.bdwmsdk.api.LogListener;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.BdWmError;
import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.utils.CmdUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class BdWmBaseService implements BdWmService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BdWmBaseService.class);

    protected BdWmConfigStorage bdWmConfigStorage;
    protected LogListener logListener;
    protected HttpHost httpProxy;
    protected CloseableHttpClient httpClient;

    @Override
    public void setBdWmConfigStorage(BdWmConfigStorage bdWmConfigStorage) {
        this.bdWmConfigStorage = bdWmConfigStorage;
    }

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    private void logging(String cmd, boolean isSuccess, String request, String response) {
        if (this.logListener != null) {
            this.logListener.requestEvent(cmd, isSuccess, request, response);
        }
    }

    @Override
    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void setHttpHost(HttpHost httpProxy) {
        this.httpProxy = httpProxy;
    }

    private Cmd createCmd(String cmdName, Object body) {
        return CmdUtils.buildCmd(bdWmConfigStorage.getSource(), bdWmConfigStorage.getSecret(), CmdUtils.VERSION, cmdName, body);
    }

    protected JSONObject execute(String cmdName, Object body) throws BdWmErrorException {
        return execute(createCmd(cmdName, body));
    }

    private JSONObject execute(Cmd cmd) throws BdWmErrorException {
        try {
            JSONObject jsonObject = sawExecute(cmd);
            return jsonObject.getJSONObject(CmdUtils.BODY);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private JSONObject sawExecute(Cmd cmd) throws IOException, BdWmErrorException {
        HttpPost httpPost = new HttpPost(CmdUtils.API_URL);
        if (httpProxy != null) {
            RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
            httpPost.setConfig(config);
        }
        String requestString = JSON.toJSONString(cmd, SerializerFeature.SortField);
        httpPost.setEntity(new StringEntity(requestString,
                Charset.forName("utf-8")));
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        if (LOGGER.isInfoEnabled()) {
            String stringBuilder = "cmd:" + cmd.toString() + "\r\n" +
                    "req:" + requestString + "\r\n" +
                    "resp:" + resultContent;
            LOGGER.info(stringBuilder);
        }
        JSONObject jsonObject = JSON.parseObject(resultContent);
        BdWmError error = BdWmError.fromJson(jsonObject);
        if (error != null) {
            logging(cmd.getCmd(), false, requestString, resultContent);
            throw new BdWmErrorException(error);
        }
        logging(cmd.getCmd(), true, requestString, resultContent);
        return jsonObject;
    }
}
