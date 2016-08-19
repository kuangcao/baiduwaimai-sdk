package com.jabangou.bdwmsdk;

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
        DishDetail products = dishService.get("27", "779");
        System.out.print(products);
    }

    @Test
    public void testGets() throws BdWmErrorException{
        DishService dishService = this.getBdWmClient().getDishService();
        List<DishProduct> products = dishService.gets("27");
        System.out.print(products);
    }

    @Test
    public void testDeleteDish() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        dishService.delete("3715", "514");
    }

    @Test
    public void testCreateDish() throws BdWmErrorException {

        Dish dish = new Dish();
        dish.setShop_id("9628");
        dish.setDish_id("9998");
        dish.setName("千层豆腐");
        dish.setPrice(1);

        dish.setPic("http://i3.meishichina.com/attachment/recipe/2012/12/18/20121218174803262083127.jpg");
        dish.setMin_order_num(1);
        dish.setPackage_box_num(1);
        dish.setDescription(ToDBC("豆豉鲮鱼真好吃， @  # % & *+ -嘿嘿花非花覅额符号的减肥还"));
        Category category = new Category();
        category.setName("菜品规格下单");
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
        dish.setStock(500);
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.update(dish);
    }

    @Test
    public void testSetStock() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        dishService.setThreshold("27", "779", 15);
    }



    @Test
    public void testOfflineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.offline("6458", "400");
    }

    @Test
    public void testOnlineDish() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        dishService.online("6458", "400");
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
}
