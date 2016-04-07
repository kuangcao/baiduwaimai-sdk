package com.jabangou.bdwmsdk;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;

/**
 * Created by wanglei on 16-3-9.
 */
public class CommonTest {

    private static Logger logger = Logger.getLogger(CommonTest.class);

    //外卖起送价，单位：分
    private int min_order_price;

    //餐盒费，单位：分
    private int package_box_price;

    //商户代码
    private String shopCode;

    //商户代码
    private String shopCode1;

    private Object aaa;

    //是否可以提供发票，1：是 2：否
    private Integer invoice_support;

    public Object getAaa() {
        return aaa;
    }

    public void setAaa(Object aaa) {
        this.aaa = aaa;
    }

    public Integer getInvoice_support() {
        return invoice_support;
    }

    public void setInvoice_support(Integer invoice_support) {
        this.invoice_support = invoice_support;
    }

    public String getShopCode1() {
        return shopCode1;
    }

    public void setShopCode1(String shopCode1) {
        this.shopCode1 = shopCode1;
    }

    public int getMin_order_price() {
        return min_order_price;
    }

    public void setMin_order_price(int min_order_price) {
        this.min_order_price = min_order_price;
    }

    public int getPackage_box_price() {
        return package_box_price;
    }

    public void setPackage_box_price(int package_box_price) {
        this.package_box_price = package_box_price;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public static void main(String[] args) throws ParseException, Exception{

//        HashMap<String,String> data = new LinkedHashMap<String,String>();
//        data.put("source_order_id", "111");
//        Map<String,Object> body = new LinkedHashMap<String,Object>();
//        body.put("errno", "1");
//        body.put("error", "success");
//        body.put("data", data);
//        CommonTest commonTest1 = new CommonTest();
//        commonTest1.setAaa(body);
//        commonTest1.setInvoice_support(1);
//        String requestJson = JSON.toJSONString(commonTest1, SerializerFeature.SortField);
//        String abc = JSON.toJSONString(body, SerializerFeature.SortField);
//        System.out.print(abc);
//        System.out.print("*****");
//        System.out.print(requestJson);
////
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////        String date = sdf.format(new Date(1442558000*1000));
////        System.out.println(date);
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = df.parse("2016-03-19");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        long timestamp = cal.getTimeInMillis();
//        System.out.println(timestamp);
//        String a = "1";
//        try {
//            if (a.equals("1")){
//                throw new InputMismatchException("测试异常");
//            }
////            throw new Exception("测试异常");
//        }catch (InputMismatchException e){
//            System.out.println("catch");
//            throw e;
//        }finally {
//            System.out.println("111");
//        }
//        for (int i = 0; i < 5; i++){
//            System.out.println(i);
//        }
//        String.valueOf(null);
//        String a = "{\"ab\":\"111\"}";
//        JSONObject object = JSON.parseObject(a);
//        System.out.print(object.getString("ab"));
//
//        String[] split = new String[]{"15", "20", "*"};
//        String date = split[1] + split[0];
////        Date currentData = new Date(date);
//        Date date1 = new Date();
//        System.out.println(date1);
//
//        String requestJson = "http/fekljf(fdsfdsfs)";
//        requestJson = requestJson.replace("/", "\\/");
//        requestJson = requestJson.replace("(", "\\u0028");
//        requestJson = requestJson.replace(")", "\\u0029");
//        requestJson = requestJson.replace("（", "\\u0028");
//        requestJson = requestJson.replace("）", "\\u0029");
//        System.out.println(requestJson);
//        System.out.printf(requestJson);

        Integer a = 10;
        Long b = Long.valueOf(a);
        System.out.println(b);
//        logger.error();
        System.out.print(DigestUtils.md5Hex("7F0B7B04946288446261063212A2F8FF"));

    }

}
