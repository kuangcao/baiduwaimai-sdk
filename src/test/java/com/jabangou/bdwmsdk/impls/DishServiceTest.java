package com.jabangou.bdwmsdk.impls;

import com.jabangou.bdwmsdk.ServiceTest;
import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Category;
import com.jiabangou.bdwmsdk.model.Dish;
import com.jiabangou.bdwmsdk.model.DishDetail;
import com.jiabangou.bdwmsdk.model.DishProduct;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-8-19.
 */
public class DishServiceTest extends ServiceTest {

    @Test
    public void testGet() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
//        DishDetail products = dishService.get("18", "692");
//        DishDetail products = dishService.get("18", "748");
        DishDetail products = dishService.get("25", "570");
        System.out.print(products);
    }

    @Test
    public void testGets() throws BdWmErrorException{
        DishService dishService = this.getBdWmClient().getDishService();
        List<DishProduct> products = dishService.gets("23");
        System.out.print(products);
    }

    @Test
    public void testDeleteDish() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        dishService.delete("test_01", "test_02");
    }

    @Test
    public void testCreateDish() throws BdWmErrorException {

        Dish dish = new Dish();
        dish.setShop_id("test_01");
        dish.setDish_id("test_01");
        dish.setName("千层豆腐");
        dish.setPrice(1);

        dish.setPic("http://i3.meishichina.com/attachment/recipe/2012/12/18/20121218174803262083127.jpg");
        dish.setMin_order_num(1);
        dish.setPackage_box_num(1);
        dish.setDescription(ToDBC("豆豉鲮鱼真好吃， @  # % & *+ -嘿嘿花非花覅额符号的减肥还"));
        Category category = new Category();
        category.setName("测试分类");
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
        dish.setShop_id("27");
        dish.setDish_id("779");

//        AvailableTime availableTime1 = new AvailableTime();
//        availableTime1.setStart("00:00");
//        availableTime1.setEnd("23:50");
//
//        AvailableTime availableTime2 = new AvailableTime();
//        availableTime2.setStart("00:00");
//        availableTime2.setEnd("23:50");
//
//        List<AvailableTime> availableTimes1 = new ArrayList<AvailableTime>();
//        availableTimes1.add(availableTime1);
//
//        List<AvailableTime> availableTimes2 = new ArrayList<AvailableTime>();
//        availableTimes2.add(availableTime2);
//
//        HashMap<String, List<AvailableTime>> available_times = new HashMap<String, List<AvailableTime>>();
//        available_times.put("1", availableTimes1);
//        available_times.put("2", availableTimes2);
//        dish.setAvailable_times(available_times);
        dish.setName("你好我是滴减肥代理商空间反垄断");
        dish.setDescription("腊八蒜炒鸭粒1份，\n" +
                "应季时蔬1份，\n" +
                "飘香米饭1份。\n" +
                "腊八蒜炒鸭粒+应季时蔬+飘香米饭=您的充电好伴侣。\n" +
                "精心炮制的腊八蒜和肥瘦适宜的鸭肉粒炒在一起，咸鲜适口，鸭肉留香，勾起我们童年中关于“腊八”的记忆。");
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.update(dish);
    }

    @Test
    public void testSetStock() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        dishService.setThreshold("test_01", "test_01", 10);
    }



    @Test
    public void testOfflineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.offline("6458", "400");
    }

    @Test
    public void testOnlineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.online("7", "43");
    }

    /**
     * 半角转全角
     * @param input String.
     * @return 全角字符串.
     */
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     * @param input String.
     * @return 半角字符串
     */
    public static String ToDBC(String input) {


        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);

            }
        }
        return new String(c);

    }

    @Test
    public void deleteStoreDish() throws BdWmErrorException {
        //门店id: 23, 24, 25, 26
        DishService dishService = this.getBdWmClient().getDishService();
        List<DishProduct> products = dishService.gets("24");
        for(DishProduct product: products){
            for(DishDetail dishDetail: product.getProducts()){
                System.out.println(dishDetail.getName());
                dishService.delete("24", dishDetail.getDish_id());
            }
        }
    }
}
