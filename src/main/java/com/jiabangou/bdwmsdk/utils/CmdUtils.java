package com.jiabangou.bdwmsdk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.model.CmdSign;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 命令构建工具类
 * Created by freeway on 16/7/30.
 */
public class CmdUtils {

    public static final String DATA = "data";
    public static final String API_URL = "http://api.waimai.baidu.com";
    public static final String VERSION = "2";
    public static final String BODY = "body";

    public static Cmd buildCmd(String source, String secret, String version, String cmdName, Object body) {
        Cmd cmd = new Cmd();
        cmd.setCmd(cmdName);
        cmd.setSource(source);
        cmd.setTicket(UUID.randomUUID().toString().toUpperCase());
        cmd.setTimestamp((int) (System.currentTimeMillis() / 1000));
        cmd.setVersion(version);
        cmd.setBody(body);
        cmd.setSign(createApiSignature(cmd, secret));
        return cmd;
    }

    public static String getResponseCmdName(String requestCmdName) {
        return "resp." + requestCmdName;
    }

    public static Cmd parseCmd(String jsonString, String source, String secret) throws BdWmErrorException {

        Cmd cmd = JSON.parseObject(jsonString, Cmd.class);
        if (cmd.getCmd() == null || cmd.getCmd().isEmpty()) {
            throw new BdWmErrorException(1, "cmd is required");
        }
        if (cmd.getSource() == null || cmd.getSource().isEmpty()) {
            throw new BdWmErrorException(1, "source is required");
        }
        if (!cmd.getSource().equals(source)) {
            throw new BdWmErrorException(1, "source is incorrect");
        }
        if (cmd.getSign() == null || cmd.getSign().isEmpty()) {
            throw new BdWmErrorException(1, "sign is required");
        }
        if (cmd.getTicket() == null || cmd.getTicket().isEmpty()) {
            throw new BdWmErrorException(1, "ticket is required");
        }
        if (cmd.getTimestamp() == 0) {
            throw new BdWmErrorException(1, "timestamp is required");
        }
        if (cmd.getVersion() == null || cmd.getVersion().isEmpty()) {
            throw new BdWmErrorException(1, "version is required");
        }
        if (!checkSignature(cmd, secret, cmd.getSign())) {
            throw new BdWmErrorException(20114, "签名不匹配");
        }
        return cmd;
    }

    public static Cmd buildSuccessCmd(String source, String secret, String version, String cmdName, Object data) {
        Map<String, Object> params = new LinkedHashMap<String, Object>() {{
            put("errno", 0);
            put("error", "success");
        }};
        if (data != null) {
            params.put("data", data);
        }
        return buildCmd(source, secret, version, cmdName, params);
    }

    public static Cmd buildSuccessCmd(String source, String secret, String version, String cmdName) {
        return buildSuccessCmd(source, secret, version, cmdName, null);
    }

    public static Cmd buildErrorCmd(String source, String secret, String version,
                                    String cmdName, BdWmErrorException exception) {
        return buildCmd(source, secret, version, cmdName, new LinkedHashMap<String, Object>() {{
            put("errno", exception.getCode());
            put("error", exception.getMessage());
        }});
    }

    public static Cmd buildErrorCmd(String source, String secret, String version,
                                    String cmdName, Exception exception) {
        return buildCmd(source, secret, version, cmdName, new LinkedHashMap<String, Object>() {{
            put("errno", -1); // 未知错误
            put("error", exception.getMessage());
        }});
    }

    public static String createApiSignature(Cmd cmd, String secret) {
        CmdSign cmdSign = new CmdSign(cmd, secret);

        String requestJson = JSONObject.toJSONString(covertToSortedMap((JSONObject)JSON.toJSON(cmdSign)));

//        String requestJson = JSON.toJSONString(cmdSign, SerializerFeature.SortField);

        requestJson = requestJson.replace("/", "\\/");
        requestJson = chinaToUnicode(requestJson);
        return DigestUtils.md5Hex(requestJson).toUpperCase();
    }

    public static SortedMap<String, Object> covertToSortedMap(Map<String, Object> map) {
        SortedMap<String, Object> sortedMap= new TreeMap<>(map);
        for (Map.Entry<String, Object> entry: sortedMap.entrySet()) {
            if (entry.getValue() instanceof Map && (!(entry.getValue() instanceof SortedMap))) {
                entry.setValue(covertToSortedMap((Map<String, Object>)entry.getValue()));
            } else if (entry.getValue() instanceof List) {
                List newList = new ArrayList<>();
                for (Object obj : (List)entry.getValue()) {
                    if (obj instanceof Map && (!(obj instanceof SortedMap))) {
                        newList.add(covertToSortedMap((Map<String, Object>)obj));
                    } else {
                        newList.add(obj);
                    }
                }
                entry.setValue(newList);
            }
        }
        return sortedMap;
    }

    /**
     * 检查签名
     *
     * @param cmd
     * @param secret
     * @param signature
     * @return
     */
    public static boolean checkSignature(Cmd cmd, String secret, String signature) {
        return createApiSignature(cmd, secret).equals(signature);
    }

    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
//            if (chr1 >= 19968 && chr1 <= 171941) {
            //解决一些符号unicode编码问题
            if (chr1 >= 127) {
                result += "\\u" + StringUtils.leftPad(Integer.toHexString(chr1), 4, "0");

            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }


}
