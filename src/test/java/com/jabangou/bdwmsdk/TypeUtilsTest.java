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

import java.util.*;

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
    public void testSign() throws BdWmErrorException {
        String jsonString = "{\"body\":{\"errno\":0,\"error\":\"success\",\"data\":{\"total\":10,\"page\":1,\"pages\":1,\"list\":[{\"order_id\":\"14576949686552\",\"status\":\"10\",\"create_time\":1457694969,\"order_status\":10},{\"order_id\":\"14576968469418\",\"status\":\"10\",\"create_time\":1457696848,\"order_status\":10},{\"order_id\":\"14576969553529\",\"status\":\"10\",\"create_time\":1457696956,\"order_status\":10},{\"order_id\":\"14577674993703\",\"status\":\"10\",\"create_time\":1457767500,\"order_status\":10},{\"order_id\":\"14577685540271\",\"status\":\"10\",\"create_time\":1457768554,\"order_status\":10},{\"order_id\":\"14577747357622\",\"status\":\"10\",\"create_time\":1457774736,\"order_status\":10},{\"order_id\":\"14577762854078\",\"status\":\"10\",\"create_time\":1457776286,\"order_status\":10},{\"order_id\":\"14579559636074\",\"status\":\"10\",\"create_time\":1457955964,\"order_status\":10},{\"order_id\":\"14580249291748\",\"status\":\"10\",\"create_time\":1458024930,\"order_status\":10},{\"order_id\":\"14580286985950\",\"status\":\"10\",\"create_time\":1458028699,\"order_status\":10}]}},\"cmd\":\"resp.order.list\",\"sign\":\"F2F89111750CEB2140A7B68B1EBFA389\",\"source\":\"65400\",\"ticket\":\"C6314A18-8633-D9B5-CB5E-126AAB0F8C53\",\"timestamp\":1469977613,\"version\":\"2\"}";
        Cmd cmd = CmdUtils.parseCmd(jsonString, "65400", "2540f3c01ae977d8");
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
