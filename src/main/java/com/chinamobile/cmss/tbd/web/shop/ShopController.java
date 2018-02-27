package com.chinamobile.cmss.tbd.web.shop;

import com.chinamobile.cmss.tbd.entity.Shop;
import com.chinamobile.cmss.tbd.result.shop.ShopResult;
import com.chinamobile.cmss.tbd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hjb on 2018/2/23.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
    @RequestMapping(value = "/shopList",method = RequestMethod.GET)
    public ShopResult getShopList(Shop shop){
        return shopService.getShopList(shop);
    }
}
