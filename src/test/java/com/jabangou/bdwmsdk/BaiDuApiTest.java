package com.jabangou.bdwmsdk;

import com.alibaba.fastjson.JSON;
import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.api.ShopService;
import com.jiabangou.bdwmsdk.api.impl.BdWmClientImpl;
import com.jiabangou.bdwmsdk.api.impl.BdWmInMemoryConfigStorage;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by wanglei on 16-3-8.
 */
public class BaiDuApiTest {

    public BdWmClientImpl getBdWmClient() {

        BdWmClientImpl bdWmClient = new BdWmClientImpl();
        BdWmInMemoryConfigStorage baiduWaimaiConfigStorage = new BdWmInMemoryConfigStorage();
        baiduWaimaiConfigStorage.setSource(0);
        baiduWaimaiConfigStorage.setSecret("");
        bdWmClient.setBaiduWaimaiConfigStorage(baiduWaimaiConfigStorage);
        return bdWmClient;
    }

    /*商户*/
    @Test
    public void testGetShop() throws BdWmErrorException {
        ShopService shopService = this.getBdWmClient().getShopService();
        ShopDetail shopDetail = shopService.getDetail("111111");
        System.out.print(shopDetail.toString());
    }

    @Test
    public void testGetShops() throws BdWmErrorException{
        ShopService shopService = this.getBdWmClient().getShopService();
        List<ShopDetailLite> shopDetails = shopService.gets();
        System.out.print(shopDetails.toString());
    }

    @Test
    public void testSetAnn() throws BdWmErrorException{
        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.setAnnouncement("1033", "我是商户公告11");
    }

    @Test
    public void testShopTest() throws BdWmErrorException {
        Shop body = new Shop();
        body.setShop_id("4");
        body.setName("东三环北路甲2号京信大厦1楼(近霄云路)东三环北路");
//        body.setShop_logo("");
        body.setProvince("北京市");
        body.setCity("北京市");
        body.setCounty("朝阳区");
        body.setAddress("东三环北路甲2号京信大厦1楼(近霄云路)");
//        body.setBrand("");
        //分类
        List<ShopCategory> categories = new ArrayList<ShopCategory>();
        ShopCategory category = new ShopCategory();
        category.setCategory1("餐饮");
        category.setCategory2("地方菜系");
        category.setCategory3("北京菜");
        categories.add(category);
        body.setCategorys(categories);
        body.setPhone("023-74558383");
        body.setService_phone("13340248649");
        body.setLongitude("116.461271");
        body.setLatitude("39.954321");
        body.setCoord_type("amap");
        //配送区域
        DeliveryRegion deliveryRegion = new DeliveryRegion();
        deliveryRegion.setName("三元桥配送区");
        deliveryRegion.setDelivery_time("60");
        deliveryRegion.setDelivery_fee("600");
        List<List<Region>> regionList = new ArrayList<List<Region>>();
        regionList.add(getRegions());
        deliveryRegion.setRegion(regionList);
        List<DeliveryRegion> deliveryRegions = new ArrayList<DeliveryRegion>();
        deliveryRegions.add(deliveryRegion);
        body.setDelivery_region(deliveryRegions);
        //营业时间
        List<BussinessTime> times = new ArrayList<BussinessTime>();
        BussinessTime bt = new BussinessTime();
        bt.setStart("07:00");
        bt.setEnd("12:00");
        BussinessTime bt2 = new BussinessTime();
        bt2.setStart("13:00");
        bt2.setEnd("23:59");
        times.add(bt);
        times.add(bt2);
        body.setBusiness_time(times);
//        body.setBook_ahead_time(1000);
        body.setInvoice_support(2);
        body.setMin_order_price(100);
        body.setPackage_box_price(10);

        ShopService shopService = this.getBdWmClient().getShopService();
        int baidu_shop_id = shopService.create(body);
        System.out.println("baidu_shop_id:" + String.valueOf(baidu_shop_id));
        System.out.println(JSON.toJSONString(body));
        String str = JSON.toJSONString(body);
        System.out.println(JSON.parseObject(str, Shop.class));
        Shop shop11 = JSON.parseObject(str, Shop.class);
        System.out.println(JSON.toJSONString(deliveryRegions));
        System.out.println("1");
    }

    @Test
    public void get() {
        getRegions();
    }

    private List<Region> getRegions() {
        String region = "116.489509,39.933892;116.48949,39.937096;116.489309,39.940804;116.489712,39.948818;116.48959,39.9527;116.489098,39.954487;116.488504,39.956011;116.487814,39.95747;116.486112,39.959424;116.482122,39.962986;116.476371,39.966547;116.465557,39.973209;116.454777,39.980273;116.449216,39.983673;116.446446,39.985809;116.444573,39.986306;116.442625,39.986021;116.436301,39.977722;116.431809,39.969871;116.432134,39.962667;116.43409,39.95329;116.434222,39.94355;116.434525,39.933808";
        String[] split = region.split(";");

        List<Region> regions = new ArrayList<Region>();

        for (String s : split) {
            Region re = new Region();
            String[] split1 = s.split(",");
            re.setLongitude(Double.parseDouble(split1[0]));
            re.setLatitude(Double.parseDouble(split1[1]));

            regions.add(re);
        }

        return regions;
    }


    @Test
    public void testUpdateShop() throws BdWmErrorException {

        Shop shop = new Shop();
        shop.setShop_id("1118");
//        shop.setName("三元桥门店测试账号");
//        shop.setShop_logo("http://img1.imgtn.bdimg.com/it/u=4054619899,643082896&fm=21&gp=0.jpg");
        ShopService shopService = this.getBdWmClient().getShopService();
//        //营业时间
        List<BussinessTime> times = new ArrayList<BussinessTime>();
        BussinessTime bt = new BussinessTime();
        bt.setStart("08:00");
        bt.setEnd("23:59");
        times.add(bt);
        shop.setBusiness_time(times);
//        shop.setBook_ahead_time(10);
//        shop.setPackage_box_price(0);
//        DeliveryRegion deliveryRegion = new DeliveryRegion();
//        deliveryRegion.setName("三桥配送区");
//        deliveryRegion.setDelivery_time("600");
//        deliveryRegion.setDelivery_fee("100");
//        List<List<Region>> regionList = new ArrayList<List<Region>>();
//        regionList.add(getRegions());
//        deliveryRegion.setRegion(regionList);
//        List<DeliveryRegion> deliveryRegions = new ArrayList<DeliveryRegion>();
//        deliveryRegions.add(deliveryRegion);
//        shop.setDelivery_region(deliveryRegions);
        boolean result = shopService.update(shop);
        System.out.print(result);
    }

    @Test
    public void testOfflineShop() throws BdWmErrorException {

        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.offline("2520");
    }

    @Test
    public void testOpenShop() throws BdWmErrorException {

        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.open("2520");
    }

    @Test
    public void testCloseShop() throws BdWmErrorException {

        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.close("test1");
    }

    @Test
    public void testSetThreshold() throws BdWmErrorException {
        List<Threshold> thresholds = new ArrayList<Threshold>();
        Threshold threshold = new Threshold();
        threshold.setNum(300);
        threshold.setTime("12|17|2");
        thresholds.add(threshold);
        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.setThreshold("test1", thresholds);
    }

    /*菜品*/
    @Test
    public void testGets() throws BdWmErrorException{
        DishService dishService = this.getBdWmClient().getDishService();
        List<DishProduct> products = dishService.gets("7");
        System.out.print(products);
    }

    @Test
    public void testGetCategory() throws BdWmErrorException{
        DishService dishService = this.getBdWmClient().getDishService();
        Category products = dishService.getCategory("1119", "测试分类1");
        System.out.print(products);
    }

    @Test
    public void testCreateCategory() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        Category category = new Category();
        category.setShop_id("1132");
        category.setName("测试分类1234576");
        category.setRank(1);
        long category_id = dishService.createCategory(category);
        System.out.print(category_id);
    }

    @Test
    public void testUpdateCategory() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        CategoryUpdate categoryUpdate = new CategoryUpdate();
        categoryUpdate.setShop_id("1001");
        categoryUpdate.setName("AA");
        categoryUpdate.setOld_name("BB");
        categoryUpdate.setRank(1);
        dishService.updateCategory(categoryUpdate);
        System.out.print(categoryUpdate);
    }

    @Test
    public void testCreateDish() throws BdWmErrorException {

        Dish dish = new Dish();
        dish.setShop_id("1132");
        dish.setDish_id("3");
        dish.setName("DY-TSC-单品001(中)");
        dish.setPrice(100);
        dish.setPic("http://i3.meishichina.com/attachment/recipe/2012/12/18/20121218174803262083127.jpg");
        dish.setMin_order_num(1);
        dish.setPackage_box_num(1);
        dish.setDescription("豆豉鲮鱼真好吃");
        Category category = new Category();
        category.setName("分类1");
        category.setRank(1);
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        dish.setCategory(categories);
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.create(dish);
    }

    @Test
    public void testUpdateDish() throws BdWmErrorException {

        Dish dish = new Dish();
        dish.setShop_id("1118");
        dish.setDish_id("465");
        dish.setPrice(1000);
        HashMap<String, List<AvailableTime>>  hashMap = new HashMap<String, List<AvailableTime>>();
        List<AvailableTime> availableTimes = new ArrayList<AvailableTime>();
        AvailableTime availableTime = new AvailableTime();
        availableTime.setStart("08:00");
        availableTime.setEnd("23:59");
        availableTimes.add(availableTime);
        hashMap.put("*", availableTimes);
        dish.setAvailable_times(hashMap);
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.update(dish);
    }

    @Test
    public void testDeleteDish() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        dishService.delete("7", "103");
    }

    @Test
    public void testOfflineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.offline("1001", "362");
    }

    @Test
    public void testOnlineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.online("1001", "362");
    }

    @Test
    public void setThreshold() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        List<Threshold> thresholds = new ArrayList<Threshold>();
        Threshold threshold = new Threshold();
        threshold.setNum(300);
        threshold.setTime("42|17|*");
        thresholds.add(threshold);

//        Threshold threshold1 = new Threshold();
//        threshold1.setNum(10);
//        threshold1.setTime("27|16|3");
//        thresholds.add(threshold1);
        dishService.setThreshold("2520", "999", thresholds);


//        List<Threshold> thresholds2 = new ArrayList<Threshold>();
//        Threshold threshold2 = new Threshold();
//        threshold2.setNum(10);
//        threshold2.setTime("37|17|*");
//        thresholds2.add(threshold);
//
////        Threshold threshold1 = new Threshold();
////        threshold1.setNum(10);
////        threshold1.setTime("27|16|3");
////        thresholds.add(threshold1);
//        dishService.setThreshold("2520", "dishId3", thresholds2);
    }

    @Test
    public void confirmOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.confirm("14577747357622");

    }

    @Test
    public void completeOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.complete("14577747357622");

    }

    @Test
    public void cancel() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.cancel("14576969553529", 1, "不在配送范围内");

    }

    @Test
    public void orderList() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.getOrderLites(1457625600, 1458316800);

    }

    @Test
    public void getOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        OrderDetail orderDetail = orderService.getOrderDetail("14576969553529");
    }

    @Test
    public void deleteDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        for (int i = 1; i < 300; i++) {
            try {
                dishService.delete("1001", String.valueOf(i));
            } catch (Exception e){
                System.out.print(i);
            }
        }
    }
}
