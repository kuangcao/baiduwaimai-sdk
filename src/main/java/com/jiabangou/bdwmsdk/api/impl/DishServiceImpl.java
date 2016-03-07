package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.bdwmsdk.api.BdWmBaseService;
import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

public class DishServiceImpl extends BdWmBaseService implements DishService {

    /*菜品*/
    //新增菜品分类
    public static final String COMMAND_DISH_CATEGORY_CREATE = "dish.category.create";

    //修改菜品分类
    public static final String COMMAND_DISH_CATEGORY_UPDATE = "dish.category.update";

    //查看单个菜品分类
    public static final String COMMAND_DISH_CATEGORY_GET = "dish.category.one";

    //查看所有菜品分类
    public static final String COMMAND_DISH_CATEGORY_ALL = "dish.category.all";

    //菜品上传
    public static final String COMMAND_DISH_CREATE = "dish.create";

    //菜品修改
    public static final String COMMAND_DISH_UPDATE = "dish.update";

    //查看菜单
    public static final String COMMAND_DISH_SHOW = "dish.show";

    //菜品上线
    public static final String COMMAND_DISH_ONLINE = "dish.online";

    //菜品下线
    public static final String COMMAND_DISH_OFFLINE = "dish.offline";

    //菜品删除
    public static final String COMMAND_DISH_DELETE = "dish.delete";

    //菜品阈值设置
    public static final String COMMAND_DISH_THRESHOLD_SET = "dish.threshold.set";

    //菜品批量替换
    public static final String COMMAND_DISH_REPLACE_BATCH = "dish.replace.batch";


    @Override
    public long createCategory(Category category) throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_DISH_CATEGORY_CREATE, category);
        JSONArray object = (JSONArray)doPost(cmd).getJSONArray(DATA);
        return ((JSONObject) object.get(0)).getIntValue("id");
    }

    @Override
    public void updateCategory(CategoryUpdate categoryUpdate) throws BdWmErrorException {
        Cmd cmd = createCmd(COMMAND_DISH_CATEGORY_UPDATE, categoryUpdate);
        doPost(cmd);
    }

    @Override
    public Category getCategory(String shopId, String name) throws BdWmErrorException {
        CategoryGet categoryGet = new CategoryGet();
        categoryGet.setName(name);
        categoryGet.setShop_id(shopId);
        Cmd cmd = createCmd(COMMAND_DISH_CATEGORY_GET, categoryGet);
        Category category = doPost(cmd).getObject("data", Category.class);
        category.setShop_id(shopId);
        return category;
    }

}
