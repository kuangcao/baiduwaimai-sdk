package com.jiabangou.baiduwaimaisdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jiabangou.baiduwaimaisdk.client.JsonResponseHandler;
import com.jiabangou.baiduwaimaisdk.client.LocalHttpClient;
import com.jiabangou.baiduwaimaisdk.exception.BaiduWaiMaiErrorException;
import com.jiabangou.baiduwaimaisdk.model.BaiDuWaiMaiConsts;
import com.jiabangou.baiduwaimaisdk.model.Request;
import com.jiabangou.baiduwaimaisdk.model.ResponseBody;
import com.jiabangou.baiduwaimaisdk.model.goods.category.create.CategoryCreateRequest;
import com.jiabangou.baiduwaimaisdk.model.goods.category.create.CategoryCreateResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class BaiDuWaiMaiServiceImpl implements BaiDuWaiMaiService {


    private static final String API_URL = "http://api.waimai.baidu.com";
    protected BaiDuWaiMaiConfigStorage baiDuwaiMaiConfigStorage = new BaiDuWaiMaiInMemoryConfigStorage();

    protected CloseableHttpClient httpClient;

    protected HttpHost httpProxy;

    protected final static LocalHttpClient localHttpClient = LocalHttpClient.getInstance();

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,
            ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,
            ContentType.APPLICATION_XML.toString());

    protected static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
            System.out.print(result);
        }
        return result;
    }

    /**
     * 菜品——新增菜品分类
     */
    public CategoryCreateResponse createCategory(CategoryCreateRequest request) throws BaiduWaiMaiErrorException {
        request.setCmd(BaiDuWaiMaiConsts.COMMAND_DISH_CATEGORY_CREATE);
        CategoryCreateResponse categoryCreateResponse = sendRequest(request,CategoryCreateResponse.class);
        checkError(categoryCreateResponse.getBody());
        return categoryCreateResponse;
    }

    public void checkError(ResponseBody responseBody) throws BaiduWaiMaiErrorException {
        if (responseBody.getErrno() != 0){
            throw new BaiduWaiMaiErrorException(responseBody.getErrno(), responseBody.getError());
        }

    }

    //发起请求
    private <T> T sendRequest(Request request, Class<T> responseClazz){
        //封装请求数据
        request.setSource(baiDuwaiMaiConfigStorage.getSource());
        request.setSecret(baiDuwaiMaiConfigStorage.getSecret());
        request.setTicket(UUID.randomUUID().toString().toUpperCase());
        request.setTimestamp((int)(System.currentTimeMillis() / 1000));
        request.setVersion(2);
        requestSign(request);
        //发起请求
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(API_URL)
                .setEntity(new StringEntity(JSON.toJSONString(request), Charset.forName("utf-8")))
                .build();
        System.out.print(request);
        return localHttpClient.execute(httpUriRequest, JsonResponseHandler.createResponseHandler(responseClazz));
    }

    private static void requestSign(Request requestData) {

        //请求签名
        String requestJson = JSON.toJSONString(requestData, SerializerFeature.SortField);
        requestJson = requestJson.replace("/", "\\/");
        requestJson = chinaToUnicode(requestJson);
        requestData.setSign(DigestUtils.md5Hex(requestJson).toUpperCase());
        requestData.setSecret(null);
        System.out.print(requestData);
    }

}
