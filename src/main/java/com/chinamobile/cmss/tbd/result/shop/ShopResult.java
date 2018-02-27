package com.chinamobile.cmss.tbd.result.shop;

import com.alibaba.fastjson.JSON;
import com.chinamobile.cmss.tbd.entity.Shop;

import java.util.List;

/**
 * Created by hjb on 2018/2/12.
 */
public class ShopResult {

    private ShopStateEnum shopStateEnum;
    private int count;
    private Shop shop;
    private List<Shop> shopList;

    public ShopStateEnum getShopStateEnum() {
        return shopStateEnum;
    }

    public void setShopStateEnum(ShopStateEnum shopStateEnum) {
        this.shopStateEnum = shopStateEnum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
