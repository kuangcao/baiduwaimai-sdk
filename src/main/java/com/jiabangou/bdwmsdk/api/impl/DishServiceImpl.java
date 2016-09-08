package com.jiabangou.bdwmsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.bdwmsdk.api.DishService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import com.jiabangou.bdwmsdk.utils.CmdUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class DishServiceImpl extends BdWmBaseService implements DishService {

    /*菜品*/
    //新增菜品分类
    public static final String COMMAND_DISH_CATEGORY_CREATE = "dish.category.create";

    //修改菜品分类
    public static final String COMMAND_DISH_CATEGORY_UPDATE = "dish.category.update";

    //查看单个菜品分类
    public static final String COMMAND_DISH_CATEGORY_GET = "dish.category.get";

    //查看所有菜品分类
    public static final String COMMAND_DISH_CATEGORY_ALL = "dish.category.all";

    //菜品上传
    public static final String COMMAND_DISH_GET = "dish.get";

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
    public static final String COMMAND_DISH_THRESHOLD_SET_V2 = "dish.threshold.setv2";

    //菜品批量替换
    public static final String COMMAND_DISH_REPLACE_BATCH = "dish.replace.batch";

    //菜品停售
    public static final String COMMAND_DISH_SALEOUT = "dish.saleout";

    @Override
    public long createCategory(Category category) throws BdWmErrorException {
        JSONArray object = execute(COMMAND_DISH_CATEGORY_CREATE, category).getJSONArray(CmdUtils.DATA);
        return object.getJSONObject(0).getIntValue("id");
    }

    @Override
    public void updateCategory(CategoryUpdate categoryUpdate) throws BdWmErrorException {
        execute(COMMAND_DISH_CATEGORY_UPDATE, categoryUpdate);
    }

    @Override
    public Category getCategory(String shopId, String name) throws BdWmErrorException {
        CategoryGet categoryGet = new CategoryGet();
        categoryGet.setName(name);
        categoryGet.setShop_id(shopId);
        try {
            return TypeUtils.castToJavaBean(execute(COMMAND_DISH_CATEGORY_GET, categoryGet)
                    .getJSONObject(CmdUtils.DATA), Category.class);
        } catch (BdWmErrorException e) {
            if (e.getCode() == BdWmErrorException.UNKNOW_CATEGORY_ERROR) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public List<Category> getAllCategory(String shopId) throws BdWmErrorException {
        Map<String, String> bodyMap = new HashMap<String, String>(1) {{
            put("shop_id", shopId);
        }};
        return execute(COMMAND_DISH_CATEGORY_ALL, bodyMap).getJSONArray(CmdUtils.DATA)
                .stream().map(o -> TypeUtils.castToJavaBean(o, Category.class)).collect(toList());
    }

    @Override
    public void create(Dish dish) throws BdWmErrorException {
        execute(COMMAND_DISH_CREATE, dish);
    }

    @Override
    public void update(Dish dish) throws BdWmErrorException {
        execute(COMMAND_DISH_UPDATE, dish);
    }

    @Override
    public void online(String shopId, String dishId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("dish_id", dishId);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_DISH_ONLINE, bodyMap);
    }

    @Override
    public void offline(String shopId, String dishId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("dish_id", dishId);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_DISH_OFFLINE, bodyMap);
    }

    @Override
    public void delete(String shopId, String dishId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("dish_id", dishId);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_DISH_DELETE, bodyMap);
    }

    @Override
    public void saleout(String shopId, String dishId) throws BdWmErrorException {
        Map<String, String> bodyMap = new LinkedHashMap<>(2);
        bodyMap.put("dish_id", dishId);
        bodyMap.put("shop_id", shopId);
        execute(COMMAND_DISH_SALEOUT, bodyMap);
    }

    @Override
    public void setThreshold(String shopId, String dishId, int stock) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(3) {{
            put("dish_id", dishId);
            put("shop_id", shopId);
            put("stock", stock);
        }};
        execute(COMMAND_DISH_THRESHOLD_SET_V2, bodyMap);
    }

    @Override
    public void replaceBatch(DishReplaceBatch dishReplaceBatch) throws BdWmErrorException {
        execute(COMMAND_DISH_REPLACE_BATCH, dishReplaceBatch);
    }

    @Override
    public List<DishProduct> gets(String shopId) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(1) {{
            put("shop_id", shopId);
        }};
        return execute(COMMAND_DISH_SHOW, bodyMap).getJSONArray(CmdUtils.DATA)
                .stream().map(o -> TypeUtils.castToJavaBean(o, DishProduct.class))
                .collect(Collectors.toList());
    }

    @Override
    public DishDetail get(String shopId, String dishId) throws BdWmErrorException {
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>(2) {{
            put("shop_id", shopId);
            put("dish_id", dishId);
        }};
        try {
            return TypeUtils.castToJavaBean(execute(COMMAND_DISH_GET, bodyMap).getJSONObject(CmdUtils.DATA), DishDetail.class);
        } catch (BdWmErrorException e){
            if (e.getCode() == BdWmErrorException.UNKNOW_DISH_ERROR){
                return null;
            }
            throw e;
        }
    }

}
