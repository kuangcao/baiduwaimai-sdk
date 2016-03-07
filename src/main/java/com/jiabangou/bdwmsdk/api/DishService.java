package com.jiabangou.bdwmsdk.api;

import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.Category;
import com.jiabangou.bdwmsdk.model.CategoryUpdate;

public interface DishService extends BdWmService {

    long createCategory(Category category) throws BdWmErrorException;

    void updateCategory(CategoryUpdate categoryUpdate) throws BdWmErrorException;

    Category getCategory(String shopId, String name) throws BdWmErrorException;

}
