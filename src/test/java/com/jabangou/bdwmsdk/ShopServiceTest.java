package com.jabangou.bdwmsdk;

import com.jiabangou.bdwmsdk.api.ShopService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-8-19.
 */
public class ShopServiceTest extends ServiceTest {

    @Test
    public void testGetShop() throws BdWmErrorException {
        ShopService shopService = this.getBdWmClient().getShopService();
        ShopDetail shopDetail = shopService.getDetail("8617");
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
    public void testShopCreate() throws BdWmErrorException {
        Shop body = new Shop();
        body.setShop_id("9998");
        body.setName("王磊测试门店1");
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
        System.out.println(baidu_shop_id);
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
        shop.setShop_id("8617");
        shop.setMin_order_price(1);
        shop.setName("天坛公园1");
        ShopService shopService = this.getBdWmClient().getShopService();
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
        shopService.open("13");
    }

    @Test
    public void testCloseShop() throws BdWmErrorException {

        ShopService shopService = this.getBdWmClient().getShopService();
        shopService.close("test1");
    }

    @Test
    public void setPic() throws BdWmErrorException {
        ShopService shopService = this.getBdWmClient().getShopService();
        List<Picture> pictures = new ArrayList<>();

        for(int i=0; i<9;i++){
            i = 9;
            int a = 9;
            Picture picture = new Picture();
            picture.setType(a);
            picture.setDesc(String.valueOf(a));
            picture.setUrl("http://i3.meishichina.com/attachment/recipe/2012/12/18/20121218174803262083127.jpg");
            pictures.add(picture);
        }

        shopService.uploadIdentityPicture("9628", pictures);
    }
}
