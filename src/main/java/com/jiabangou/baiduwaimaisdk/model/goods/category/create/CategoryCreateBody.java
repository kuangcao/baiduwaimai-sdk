package com.jiabangou.baiduwaimaisdk.model.goods.category.create;

/**
 * Created by wanglei on 16-3-3.
 */
public class CategoryCreateBody {

    // 合作方商户唯一 ID
    private String shop_id;

    // 名称
    private String name;

    //降序排序，大于0
    private int rank;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
