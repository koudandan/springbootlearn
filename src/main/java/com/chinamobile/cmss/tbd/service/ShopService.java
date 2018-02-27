package com.chinamobile.cmss.tbd.service;

import com.chinamobile.cmss.tbd.entity.Shop;
import com.chinamobile.cmss.tbd.result.shop.ShopResult;

import java.util.List;

/**
 * Created by hjb on 2018/2/12.
 */
public interface ShopService {

    ShopResult getShopList(Shop shop);

}
