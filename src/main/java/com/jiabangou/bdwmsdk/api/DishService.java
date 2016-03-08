package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.*;
import com.sun.tools.javac.util.List;

public interface DishService extends BdWmService {

    long createCategory(Category category) throws BdWmErrorException;

    void updateCategory(CategoryUpdate categoryUpdate) throws BdWmErrorException;

    Category getCategory(String shopId, String name) throws BdWmErrorException;

    List<Category> getAllCategory(String shopId) throws BdWmErrorException;

    void create(Dish dish) throws BdWmErrorException;

    void update(Dish dish) throws BdWmErrorException;

    void online(String shopId, String dishId) throws BdWmErrorException;

    void offline(String shopId, String dishId) throws BdWmErrorException;

    void delete(String shopId, String dishId) throws BdWmErrorException;

    void setThreshold(String shopId, String dishId, List<Threshold> thresholds) throws BdWmErrorException;

    void replaceBatch(DishReplaceBatch dishReplaceBatch) throws BdWmErrorException;

}
