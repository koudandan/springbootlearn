package com.chinamobile.cmss.tbd.service.impl;

import com.chinamobile.cmss.tbd.dao.ShopMapper;
import com.chinamobile.cmss.tbd.entity.Shop;
import com.chinamobile.cmss.tbd.result.shop.ShopResult;
import com.chinamobile.cmss.tbd.result.shop.ShopStateEnum;
import com.chinamobile.cmss.tbd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by hjb on 2018/2/12.
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Override
    public ShopResult getShopList(Shop shop) {
        ShopResult shopResult = new ShopResult();
        shopResult.setShopStateEnum(ShopStateEnum.SUCCESS);
        shopResult.setShopList(shopMapper.queryShopList(shop));
        return shopResult;
    }
}
