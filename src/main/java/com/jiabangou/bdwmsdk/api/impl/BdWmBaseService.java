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
import com.jiabangou.bdwmsdk.model.CmdSign;
import org.apache.commons.codec.digest.DigestUtils;
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
import java.util.UUID;

public class BdWmBaseService implements BdWmService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BdWmBaseService.class);

    public static final String DATA = "data";
    public static final String API_URL = "http://api.waimai.baidu.com";
    public static final int VERSION = 2;
    public static final String BODY = "body";
    protected BdWmConfigStorage bdWmConfigStorage;
    protected LogListener logListener;
    protected HttpHost httpProxy;
    protected CloseableHttpClient httpClient;

    protected static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

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

    protected Cmd createCmd(String cmdName, Object body) {
        Cmd cmd = new Cmd();
        cmd.setCmd(cmdName);
        cmd.setSource(bdWmConfigStorage.getSource());
        cmd.setTicket(UUID.randomUUID().toString().toUpperCase());
        cmd.setTimestamp((int) (System.currentTimeMillis() / 1000));
        cmd.setVersion(VERSION);
        cmd.setBody(body);
        cmd.setSign(createApiSignature(cmd));
        return cmd;
    }

    protected String createApiSignature(Cmd cmd) {
        CmdSign cmdSign = new CmdSign(cmd, bdWmConfigStorage.getSecret());
        String requestJson = JSON.toJSONString(cmdSign, SerializerFeature.SortField);
        requestJson = requestJson.replace("/", "\\/");
        requestJson = chinaToUnicode(requestJson);
        return DigestUtils.md5Hex(requestJson).toUpperCase();
    }

    protected JSONObject execute(Cmd cmd) throws BdWmErrorException {
        try {
            HttpPost httpPost = new HttpPost(API_URL);
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
                StringBuilder stringBuilder = new StringBuilder("cmd:").append(cmd.toString()).append("\r\n")
                        .append("req:").append(requestString).append("\r\n")
                        .append("resp:").append(resultContent);
                LOGGER.info(stringBuilder.toString());
            }
            JSONObject jsonObject = JSON.parseObject(resultContent);
            BdWmError error = BdWmError.fromJson(jsonObject);
            if (error != null) {
                logging(cmd.getCmd(), false, requestString, resultContent);
                throw new BdWmErrorException(error);
            }
            logging(cmd.getCmd(), true, requestString, resultContent);
            return jsonObject.getJSONObject(BODY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
