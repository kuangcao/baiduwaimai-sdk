package com.jabangou.bdwmsdk;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Cmd;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import com.jiabangou.bdwmsdk.model.OrderLite;
import com.jiabangou.bdwmsdk.model.Page;
import com.jiabangou.bdwmsdk.utils.CmdUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.jiabangou.bdwmsdk.utils.CmdUtils.chinaToUnicode;

/**
 * Created by freeway on 16/7/31.
 */
public class TypeUtilsTest {

    @Test
    public void testOrderDetailConverter() {
        String jsonString = "{\n" +
                "            \"source\": \"65400\",\n" +
                "            \"shop\": {\n" +
                "                \"id\": \"10085273789351720461\",\n" +
                "                \"name\": \"测试店铺(知春路)\",\n" +
                "                \"baidu_shop_id\": \"100852737893517\"\n" +
                "            },\n" +
                "            \"order\": {\n" +
                "                \"order_id\": \"14526785626179\",\n" +
                "                \"send_immediately\": 1,\n" +
                "                \"send_time\": \"1\",\n" +
                "                \"send_fee\": 500,\n" +
                "                \"package_fee\": 0,\n" +
                "                \"discount_fee\": 1500,\n" +
                "                \"total_fee\": 3700,\n" +
                "                \"shop_fee\": 2520,\n" +
                "                \"user_fee\": 2200,\n" +
                "                \"pay_type\": 2,\n" +
                "                \"pay_status\": 2,\n" +
                "                \"need_invoice\": 2,\n" +
                "                \"invoice_title\": \"\",\n" +
                "                \"remark\": \"\",\n" +
                "                \"delivery_party\": 1,\n" +
                "                \"create_time\": \"1452678562\",\n" +
                "                \"cancel_time\": \"0\"\n" +
                "            },\n" +
                "            \"user\": {\n" +
                "                \"name\": \"胡先生\",\n" +
                "                \"phone\": \"16800168000\",\n" +
                "                \"gender\": 2,\n" +
                "                \"address\": \"百度(奎科科技大厦) 二楼A区\",\n" +
                "                \"coord\": {\n" +
                "                    \"longitude\": 116.313397,\n" +
                "                    \"latitude\": 40.047773\n" +
                "                }\n" +
                "            },\n" +
                "            \"products\": [\n" +
                "                {\n" +
                "                    \"product_id\": \"7305179757366483271\",\n" +
                "                    \"upc\": \"\",\n" +
                "                    \"product_name\": \"南瓜百合粥\",\n" +
                "                    \"product_price\": 700,\n" +
                "                    \"product_amount\": 1,\n" +
                "                    \"product_fee\": 700,\n" +
                "                    \"package_price\": 0,\n" +
                "                    \"package_amount\": \"1\",\n" +
                "                    \"package_fee\": 0,\n" +
                "                    \"total_fee\": 700\n" +
                "                },\n" +
                "                {\n" +
                "                    \"product_id\": \"11348957995977290482\",\n" +
                "                    \"upc\": \"\",\n" +
                "                    \"product_name\": \"牛肉米粉\",\n" +
                "                    \"product_price\": 1400,\n" +
                "                    \"product_amount\": 1,\n" +
                "                    \"product_fee\": 1400,\n" +
                "                    \"package_price\": 0,\n" +
                "                    \"package_amount\": \"1\",\n" +
                "                    \"package_fee\": 0,\n" +
                "                    \"total_fee\": 1400\n" +
                "                },\n" +
                "                {\n" +
                "                    \"product_id\": \"2360367870545372032\",\n" +
                "                    \"upc\": \"\",\n" +
                "                    \"product_name\": \"招牌鸡丝凉面\",\n" +
                "                    \"product_price\": 900,\n" +
                "                    \"product_amount\": 1,\n" +
                "                    \"product_fee\": 900,\n" +
                "                    \"package_price\": 0,\n" +
                "                    \"package_amount\": \"1\",\n" +
                "                    \"package_fee\": 0,\n" +
                "                    \"total_fee\": 900\n" +
                "                },\n" +
                "                {\n" +
                "                    \"product_id\": \"1449508433\",\n" +
                "                    \"upc\": \"\",\n" +
                "                    \"product_name\": \"荷包蛋\",\n" +
                "                    \"product_price\": 200,\n" +
                "                    \"product_amount\": 1,\n" +
                "                    \"product_fee\": 200,\n" +
                "                    \"package_price\": 0,\n" +
                "                    \"package_amount\": \"1\",\n" +
                "                    \"package_fee\": 0,\n" +
                "                    \"total_fee\": 200\n" +
                "                }\n" +
                "            ],\n" +
                "            \"discount\": [\n" +
                "                {\n" +
                "                    \"type\": \"jian\",\n" +
                "                    \"activity_id\": \"50105\",\n" +
                "                    \"rule_id\": \"103145\",\n" +
                "                    \"fee\": 1500,\n" +
                "                    \"baidu_rate\": 1300,\n" +
                "                    \"shop_rate\": 200,\n" +
                "                    \"agent_rate\": 0,\n" +
                "                    \"logistics_rate\": 0,\n" +
                "                    \"desc\": \"立减优惠\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }";
        OrderDetail orderDetail = JSONObject.parseObject(jsonString, OrderDetail.class);
        System.out.println(orderDetail);

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println(TypeUtils.castToJavaBean(jsonObject, OrderDetail.class));
    }

    @Test
    public void testTypeReference() {
        String jsonString = "{\n" +
                "            \"total\": 1,\n" +
                "            \"page\": 1,\n" +
                "            \"pages\": 1,\n" +
                "            \"list\": [\n" +
                "                {\n" +
                "                    \"order_id\": \"14526825440149\",\n" +
                "                    \"status\": \"1\",\n" +
                "                    \"create_time\": 1452682544,\n" +
                "                    \"order_status\": 1\n" +
                "                }\n" +
                "            ]\n" +
                "        }";
        TypeReference typeReference = new TypeReference<Page<OrderLite>>(){};
        System.out.println(JSONObject.parseObject(jsonString, typeReference));
//        TypeUtils.castToJavaBean(jsonObject, typeReference.getType().getClass());
    }

    @Test
    public void testPushData() {
        String jsonString = "{\n" +
                "    \"body\": {\n" +
                "        \"shop\": {\n" +
                "            \"id\": \"2520\",\n" +
                "            \"name\": \"百度外卖（测试店）\"\n" +
                "        },\n" +
                "        \"order\": {\n" +
                "            \"order_id\": \"14347012309352\",\n" +
                "            \"send_immediately\": 1,\n" +
                "            \"send_time\": \"1\",\n" +
                "            \"send_fee\": 500,\n" +
                "            \"package_fee\": 200,\n" +
                "            \"discount_fee\": 0,\n" +
                "            \"total_fee\": 3700,\n" +
                "            \"shop_fee\": 3200,\n" +
                "            \"user_fee\": 3700,\n" +
                "            \"pay_type\": 1,\n" +
                "            \"pay_status\": 1,\n" +
                "            \"need_invoice\": 2,\n" +
                "            \"invoice_title\": \"\",\n" +
                "            \"remark\": \"请提供餐具\",\n" +
                "            \"delivery_party\": 1,\n" +
                "            \"create_time\": \"1434701230\"\n" +
                "        },\n" +
                "        \"user\": {\n" +
                "            \"name\": \"测试订单请勿操作\",\n" +
                "            \"phone\": \"18912345678\",\n" +
                "            \"gender\": 1,\n" +
                "            \"address\": \"北京海淀区奎科科技大厦 测试\",\n" +
                "            \"coord\": {\n" +
                "                \"longitude\": 116.143145,\n" +
                "                \"latitude\": 39.741426\n" +
                "            }\n" +
                "        },\n" +
                "        \"products\": [\n" +
                "            {\n" +
                "                \"product_id\": \"12277320\",\n" +
                "                \"product_name\": \"酱肉包（/份）\",\n" +
                "                \"product_price\": 1200,\n" +
                "                \"product_amount\": 1,\n" +
                "                \"product_fee\": 1200,\n" +
                "                \"package_price\": 100,\n" +
                "                \"package_amount\": 1,\n" +
                "                \"package_fee\": 100,\n" +
                "                \"total_fee\": 1300,\n" +
                "                \"upc\": \"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"discount\": []\n" +
                "    },\n" +
                "    \"cmd\": \"order.create\",\n" +
                "    \"sign\": \"E362B8AACE4F7A77047A885C0C0D230D\",\n" +
                "    \"source\": \"65400\",\n" +
                "    \"ticket\": \"909C3B92-8CDD-AF2C-C887-5B660233E2B2\",\n" +
                "    \"timestamp\": 1434701234,\n" +
                "    \"version\": \"2.0\"\n" +
                "}";
        Cmd cmd = JSONObject.parseObject(jsonString, Cmd.class);
        System.out.println(cmd);
    }

    @Test
    public void testJson(){
        String json = "{\"body\":{\"discount\":[{\"activity_id\":\"653873\",\"agent_rate\":0,\"baidu_rate\":0,\"desc\":\"\\u7acb\\u51cf\\u4f18\\u60e0\",\"fee\":500,\"logistics_rate\":0,\"rule_id\":815075,\"shop_rate\":500,\"type\":\"jian\"}],\"order\":{\"create_time\":\"1472531236\",\"delivery_party\":1,\"discount_fee\":500,\"invoice_title\":\"\",\"need_invoice\":2,\"order_id\":\"14725312367946\",\"package_fee\":0,\"pay_status\":2,\"pay_type\":2,\"remark\":\"\",\"send_fee\":500,\"send_immediately\":1,\"send_time\":\"1\",\"shop_fee\":6308,\"total_fee\":7900,\"user_fee\":7400},\"products\":[{\"package_amount\":\"1\",\"package_fee\":0,\"package_price\":0,\"product_amount\":1,\"product_fee\":6800,\"product_id\":\"43\",\"product_name\":\"\\u5168\\u805a\\u5fb7\\u624b\\u4f5c\\u9e2d\\u5377\",\"product_price\":6800,\"total_fee\":6800,\"upc\":\"\"},{\"package_amount\":\"1\",\"package_fee\":0,\"package_price\":0,\"product_amount\":1,\"product_fee\":600,\"product_id\":\"147\",\"product_name\":\"\\u5317\\u51b0\\u6d0b-\\u6a59\\u5473\",\"product_price\":600,\"total_fee\":600,\"upc\":\"\"}],\"shop\":{\"baidu_shop_id\":\"1600777150\",\"id\":\"2\",\"name\":\"\\u5168\\u805a\\u5fb7\\uff08\\u897f\\u5ba2\\u7ad9\\u5e97\\uff09\"},\"source\":\"30137\",\"user\":{\"address\":\"\\u4e3d\\u6c34\\u83b2\\u82b1\\u4fe1\\u5821·\\u6c34\\u5cb8\\u516c\\u9986 2\\u53f7\\u697c1\\u5355\\u5143\",\"coord\":{\"latitude\":39.898306,\"longitude\":116.335843},\"gender\":1,\"name\":\"\\u90ed\\u6dfc\",\"phone\":\"13910777267\"}},\"cmd\":\"order.create\",\"secret\":\"66a2b33605692114\",\"source\":\"30137\",\"ticket\":\"4F83EDBF-5920-BF64-02BF-40709E303798\",\"timestamp\":1472531256,\"version\":\"2.0\"}";
        System.out.println(getMD5(json));
        System.out.println(chinaToUnicode("。"));
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSign() throws BdWmErrorException {
        String jsonString = "{\n" +
                "    \"body\": {\n" +
                "        \"source\": \"30137\",\n" +
                "        \"shop\": {\n" +
                "            \"id\": \"7\",\n" +
                "            \"name\": \"全聚德（望京店）\",\n" +
                "            \"baidu_shop_id\": \"1600777377\"\n" +
                "        },\n" +
                "        \"order\": {\n" +
                "            \"order_id\": \"14726117347342\",\n" +
                "            \"send_immediately\": 1,\n" +
                "            \"send_time\": \"1\",\n" +
                "            \"send_fee\": 500,\n" +
                "            \"package_fee\": 0,\n" +
                "            \"discount_fee\": 3700,\n" +
                "            \"total_fee\": 7300,\n" +
                "            \"shop_fee\": 2852,\n" +
                "            \"user_fee\": 3600,\n" +
                "            \"pay_type\": 2,\n" +
                "            \"pay_status\": 2,\n" +
                "            \"need_invoice\": 1,\n" +
                "            \"invoice_title\": \"北京奥瑞国际投资控股股份有限公司，发票金额：20元。\",\n" +
                "            \"remark\": \"\",\n" +
                "            \"delivery_party\": 1,\n" +
                "            \"create_time\": \"1472611734\"\n" +
                "        },\n" +
                "        \"user\": {\n" +
                "            \"name\": \"霍妍\",\n" +
                "            \"phone\": \"15275202316\",\n" +
                "            \"gender\": 2,\n" +
                "            \"address\": \"北京丽都维景酒店 丽都假日酒店T4办公室\",\n" +
                "            \"coord\": {\n" +
                "                \"longitude\": 116.485548,\n" +
                "                \"latitude\": 39.984232\n" +
                "            }\n" +
                "        },\n" +
                "        \"products\": [\n" +
                "            {\n" +
                "                \"product_id\": \"564\",\n" +
                "                \"upc\": \"\",\n" +
                "                \"product_name\": \"干锅鸭脯菜花\",\n" +
                "                \"product_price\": 2800,\n" +
                "                \"product_amount\": 1,\n" +
                "                \"product_fee\": 2800,\n" +
                "                \"package_price\": 0,\n" +
                "                \"package_amount\": \"1\",\n" +
                "                \"package_fee\": 0,\n" +
                "                \"total_fee\": 2800\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"493\",\n" +
                "                \"upc\": \"\",\n" +
                "                \"product_name\": \"麻婆鸭肉豆腐套餐\",\n" +
                "                \"product_price\": 3800,\n" +
                "                \"product_amount\": 1,\n" +
                "                \"product_fee\": 3800,\n" +
                "                \"package_price\": 0,\n" +
                "                \"package_amount\": \"1\",\n" +
                "                \"package_fee\": 0,\n" +
                "                \"total_fee\": 3800\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"109\",\n" +
                "                \"upc\": \"\",\n" +
                "                \"product_name\": \"香米饭\",\n" +
                "                \"product_price\": 200,\n" +
                "                \"product_amount\": 1,\n" +
                "                \"product_fee\": 200,\n" +
                "                \"package_price\": 0,\n" +
                "                \"package_amount\": \"1\",\n" +
                "                \"package_fee\": 0,\n" +
                "                \"total_fee\": 200\n" +
                "            }\n" +
                "        ],\n" +
                "        \"discount\": [\n" +
                "            {\n" +
                "                \"type\": \"te\",\n" +
                "                \"activity_id\": \"0\",\n" +
                "                \"rule_id\": 0,\n" +
                "                \"fee\": 3700,\n" +
                "                \"baidu_rate\": 0,\n" +
                "                \"shop_rate\": 3700,\n" +
                "                \"agent_rate\": 0,\n" +
                "                \"logistics_rate\": 0,\n" +
                "                \"desc\": \"特价优惠\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"cmd\": \"order.create\",\n" +
                "    \"sign\": \"F09D18E11329EB3CE439D67070FFAF58\",\n" +
                "    \"source\": \"30137\",\n" +
                "    \"ticket\": \"0F6B04CF-A1C5-21ED-5A19-D2CB246D3A4D\",\n" +
                "    \"timestamp\": 1472611747,\n" +
                "    \"version\": \"2.0\"\n" +
                "}";
        Cmd cmd = CmdUtils.parseCmd(jsonString, "30137", "66a2b33605692114");
        System.out.println(cmd);
    }

    @Test
    public void testSortedMap() {
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("1","11");
        map.put("aaa", "aaa");
        map.put("4", "33");
        map.put("5", "55");
        map.put("bbb", "bbb");
        map.put("2", "22");
        map.put("3", "33");
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());

        }
        System.out.println("======================================================");
        SortedMap<String,String> sort= new TreeMap<>(map);
        for (Map.Entry<String,String> entry: sort.entrySet()) {
            System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
        }
    }
}
