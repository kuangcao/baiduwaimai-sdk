package com.jabangou.bdwmsdk.dish;

import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.api.impl.BdWmClientImpl;
import com.jiabangou.bdwmsdk.api.impl.BdWmInMemoryConfigStorage;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Category;
import org.junit.Test;

/**
 * Created by wanglei on 16-3-8.
 */
public class DishTest {

    @Test
    public void createCategory() throws BdWmErrorException {
        BdWmClientImpl bdWmClient = new BdWmClientImpl();
        BdWmInMemoryConfigStorage baiduWaimaiConfigStorage = new BdWmInMemoryConfigStorage();
        baiduWaimaiConfigStorage.setSource(65400);
        baiduWaimaiConfigStorage.setSecret("2540f3c01ae977d8");
        bdWmClient.setBaiduWaimaiConfigStorage(baiduWaimaiConfigStorage);
        DishService dishService = bdWmClient.getDishService();
        Category category = new Category();
        category.setShop_id("test1");
        category.setName("菜品分类8");
        category.setRank(1);
        long category_id = dishService.createCategory(category);
        System.out.print(category_id);
    }

}
