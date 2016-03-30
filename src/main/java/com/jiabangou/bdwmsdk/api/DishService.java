package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;

import java.util.List;

public interface DishService extends BdWmService {

    /**
     * <pre>
     * 创建菜品分类信息
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_category_create
     * </pre>
     * @param category 菜品分类信息
     * @return 菜品分类id
     * @throws BdWmErrorException
     */
    long createCategory(Category category) throws BdWmErrorException;

    /**
     * <pre>
     * 更新菜品分类信息
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_category_update
     * </pre>
     * @param categoryUpdate 菜品信息
     * @throws BdWmErrorException
     */
    void updateCategory(CategoryUpdate categoryUpdate) throws BdWmErrorException;

    /**
     * <pre>
     * 获取单个菜品分类信息
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_category_get
     * </pre>
     * @param shopId 商户id
     * @param name 分类的名字
     * @return 菜品分类信息
     * @throws BdWmErrorException
     */
    Category getCategory(String shopId, String name) throws BdWmErrorException;

    /**
     * <pre>
     * 获取所有菜品分类信息
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_category_all
     * </pre>
     * @param shopId 商户id
     * @return 菜品分类列表
     * @throws BdWmErrorException
     */
    List<Category> getAllCategory(String shopId) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品上传
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_create
     * </pre>
     * @param dish 菜品信息
     * @throws BdWmErrorException
     */
    void create(Dish dish) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品修改
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_update
     * </pre>
     * @param dish 菜品信息
     * @throws BdWmErrorException
     */
    void update(Dish dish) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品上线
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_online
     * </pre>
     * @param shopId 商户id
     * @param dishId 菜品id
     * @throws BdWmErrorException
     */
    void online(String shopId, String dishId) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品下线
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_offline
     * </pre>
     * @param shopId 商户id
     * @param dishId 菜品id
     * @throws BdWmErrorException
     */
    void offline(String shopId, String dishId) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品删除
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_delete
     * </pre>
     * @param shopId 商户id
     * @param dishId 菜品id
     * @throws BdWmErrorException
     */
    void delete(String shopId, String dishId) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品库存阈值设置
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_threshold_set
     * </pre>
     * @param shopId 商户id
     * @param dishId 菜品id
     * @param thresholds 库存阈值
     * @throws BdWmErrorException
     */
    void setThreshold(String shopId, String dishId, List<Threshold> thresholds) throws BdWmErrorException;

    /**
     * <pre>
     * 菜品批量替换
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_replace_batch
     * </pre>
     * @param dishReplaceBatch 批量菜品对象
     * @throws BdWmErrorException
     */
    void replaceBatch(DishReplaceBatch dishReplaceBatch) throws BdWmErrorException;

    /**
     * <pre>
     * 获取商户菜品列表
     * 详情请见: http://api.waimai.baidu.com/openapi/doc/interface?md=API2.0_dish_show
     * </pre>
     * @param shopId 商户id
     * @throws BdWmErrorException
     */
    List<DishProduct> gets(String shopId) throws BdWmErrorException;

}
