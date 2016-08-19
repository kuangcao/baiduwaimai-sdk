package com.jabangou.bdwmsdk;

import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Category;
import com.jiabangou.bdwmsdk.model.CategoryUpdate;
import org.junit.Test;

import java.util.List;

/**
 * Created by wanglei on 16-8-19.
 */
public class DishCategoryServiceTest extends ServiceTest {

    @Test
    public void testGetCategory() throws BdWmErrorException {
        DishService dishService = this.getBdWmClient().getDishService();
        List<Category> categories = dishService.getAllCategory("8731");
        System.out.print(categories);
    }

    @Test
    public void testCreateCategory() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        Category category = new Category();
        category.setShop_id("9628");
        category.setName("菜品规格下单");
        category.setRank(1);
        long category_id = dishService.createCategory(category);
        System.out.print(category_id);
    }

    @Test
    public void testUpdateCategory() throws BdWmErrorException {

        DishService dishService = this.getBdWmClient().getDishService();
        CategoryUpdate categoryUpdate = new CategoryUpdate();
        categoryUpdate.setShop_id("1762");
        categoryUpdate.setName("测试分类4");
        categoryUpdate.setOld_name("测试1");
        categoryUpdate.setRank(1);
        dishService.updateCategory(categoryUpdate);
        System.out.print(categoryUpdate);
    }

}
